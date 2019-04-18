package org.ohdsi.analysis.versioning;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CdmVersionUtils {

    private static final String VERSION_X_RANGE = "*";

    public static void determineCdmCompatibility(CdmCompatibilitySpec compatibilitySpec) {

        compatibilitySpec.setCdmVersionRange(MoreObjects.firstNonNull(compatibilitySpec.getCdmVersionRange(), VERSION_X_RANGE));

        Map<String, String> derivedCdmRanges = new HashMap<>();
        resolveCdmRanges(derivedCdmRanges, null, compatibilitySpec);

        if (derivedCdmRanges.size() > 0) {
            String derivedIntersection = SemverUtils.getRangesIntersection(new ArrayList<>(derivedCdmRanges.values()));
            if (derivedIntersection == null) {
                throw new IncompatibleVersionsException("Selected parameters don't have a common compatible CDM range");
            }

            if (!compatibilitySpec.getCdmVersionRange().equals(VERSION_X_RANGE)) {
                String overallIntersection = SemverUtils.getRangesIntersection(Arrays.asList(compatibilitySpec.getCdmVersionRange(), derivedIntersection));
                if (overallIntersection == null || !overallIntersection.equals(compatibilitySpec.getCdmVersionRange())) {
                    throw new IncompatibleVersionsException(
                            String.format("User-defined CDM range (%s) does not include derived CDM range (%s)", compatibilitySpec.getCdmVersionRange(), derivedIntersection)
                    );
                }
            } else {
                compatibilitySpec.setCdmVersionRange(derivedIntersection);
            }
        }
    }

    private static void resolveCdmRanges(Map<String, String> ranges, String path, Object obj) {

        try {
            String r;
            if ((r = parseCdmRange(obj.getClass())) != null) {
                ranges.put(rangeKey(obj.getClass().getSimpleName(), null, path), r);
            }
            for (Field field : obj.getClass().getFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null) {
                    String fieldPath = joinPath(path, field);
                    if ((r = parseCdmRange(field)) != null) {
                        ranges.put(rangeKey(obj.getClass().getSimpleName(), field.getName(), fieldPath), r);
                    }
                    if (!ClassUtils.isPrimitiveOrWrapper(field.getType()) && !(value instanceof Enum) && !(value instanceof String)) {
                        if (value instanceof Object[]) {
                            int i = 0;
                            for (Object v : (Object[]) value) {
                                resolveCdmRanges(ranges, joinPathIdx(fieldPath, i++), v);
                            }
                        } else if (value instanceof Iterable) {
                            int[] idx = {0};
                            ((Iterable) value).forEach(v -> resolveCdmRanges(ranges, joinPathIdx(fieldPath, idx[0]++), v));
                        } else {
                            resolveCdmRanges(ranges, fieldPath, value);
                        }
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String joinPath(String path, Field field) {

        return joinPath(path, field.getName());
    }

    private static String joinPathIdx(String path, int i) {

        return path + "[" + i + "]";
    }

    private static String joinPath(String path, String crumb) {

        return Arrays.asList(path, crumb).stream().filter(Objects::nonNull).collect(Collectors.joining("."));
    }

    private static String parseCdmRange(AnnotatedElement element) {

        CdmVersion cdmVersion = element.getAnnotation(CdmVersion.class);
        return cdmVersion != null ? cdmVersion.range() : null;
    }

    private static String rangeKey(String clazz, String prop, String path) {

        return clazz + (prop != null ? "." + prop : "") + " (" + path + ")";
    }
}
