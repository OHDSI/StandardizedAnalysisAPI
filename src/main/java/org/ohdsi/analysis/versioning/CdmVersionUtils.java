package org.ohdsi.analysis.versioning;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CdmVersionUtils {

    private static final String VERSION_X_RANGE = "*";

    public static void determineCdmCompatibility(CdmCompatibilitySpec compatibilitySpec) {

        List<String> cdmRanges = new ArrayList<>();
        resolveCdmRanges(cdmRanges, compatibilitySpec);
        if (cdmRanges.size() > 0) {
            String rangesIntersection = SemverUtils.getRangesIntersection(cdmRanges);
            compatibilitySpec.setCdmVersion(rangesIntersection);
        } else {
            compatibilitySpec.setCdmVersion(VERSION_X_RANGE);
        }
    }

    private static void resolveCdmRanges(List<String> ranges, Object obj) {

        try {
            parseCdmRange(obj.getClass(), ranges);
            for (Field field : obj.getClass().getFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null) {
                    parseCdmRange(field, ranges);
                    if (!ClassUtils.isPrimitiveOrWrapper(field.getType()) && !(value instanceof Enum) && !(value instanceof String)) {
                        if (value instanceof Object[]) {
                            for (Object v : (Object[]) value) {
                                resolveCdmRanges(ranges, v);
                            }
                        } else if (value instanceof Iterable) {
                            ((Iterable) value).forEach(v -> resolveCdmRanges(ranges, v));
                        } else {
                            resolveCdmRanges(ranges, value);
                        }
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void parseCdmRange(AnnotatedElement element, List<String> ranges) {

        CdmVersion cdmVersion = element.getAnnotation(CdmVersion.class);
        if (cdmVersion != null) {
            ranges.add(cdmVersion.semver());
        }
    }
}
