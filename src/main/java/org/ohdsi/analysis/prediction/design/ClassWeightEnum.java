package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public enum ClassWeightEnum {

    NONE("None"),
    BALANCED("Balanced");

    private final String value;

    ClassWeightEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ClassWeightEnum fromValue(String text) {
        for (ClassWeightEnum b : ClassWeightEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

}
