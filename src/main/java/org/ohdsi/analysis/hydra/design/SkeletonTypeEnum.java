package org.ohdsi.analysis.hydra.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Corresponds to the skeleton types supported by the Hydra R package
 */
public enum SkeletonTypeEnum {

    /**
     *
     */
    COMPARATIVE_EFFECT_STUDY("ComparativeEffectStudy"),
    /**
     *
     */
    PATIENT_LEVEL_PREDICTION_STUDY("PatientLevelPredictionStudy");

    /**
     *
     */
    private final String value;

    SkeletonTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    /**
     *
     * @param text
     * @return
     */
    @JsonCreator
    public static SkeletonTypeEnum fromValue(String text) {
        for (SkeletonTypeEnum b : SkeletonTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
