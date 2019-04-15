package org.ohdsi.analysis.versioning;

import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

public class CdmVersionUtils {

    public static void determineCdmCompatibility(CdmCompatibilitySpec compatibilitySpec) {

        determineCdmCompatibility(compatibilitySpec, compatibilitySpec);
    }

    private static void determineCdmCompatibility(CdmCompatibilitySpec compatibilitySpec, Object obj) {

        try {
            updateCdmCompatibility(obj.getClass(), compatibilitySpec);
            for (Field field : obj.getClass().getFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null) {
                    updateCdmCompatibility(field, compatibilitySpec);
                    if (!ClassUtils.isPrimitiveOrWrapper(field.getType()) && !(value instanceof Enum) && !(value instanceof String)) {
                        if (value instanceof Object[]) {
                            for (Object v : (Object[]) value) {
                                determineCdmCompatibility(compatibilitySpec, v);
                            }
                        } else if (value instanceof Iterable) {
                            ((Iterable) value).forEach(v -> determineCdmCompatibility(compatibilitySpec, v));
                        } else {
                            determineCdmCompatibility(compatibilitySpec, value);
                        }
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void updateCdmCompatibility(AnnotatedElement element, CdmCompatibilitySpec compatibilitySpec) {

        CdmVersion cdmVersion = element.getAnnotation(CdmVersion.class);
        if (cdmVersion != null) {
            if (cdmVersion.min() != 0 && cdmVersion.min() > compatibilitySpec.getMinCdmVersion()) {
                compatibilitySpec.setMinCdmVersion(cdmVersion.min());
            }
            if (cdmVersion.max() != 0 && cdmVersion.max() < compatibilitySpec.getMaxCdmVersion()) {
                compatibilitySpec.setMaxCdmVersion(cdmVersion.max());
            }
        }
    }
}
