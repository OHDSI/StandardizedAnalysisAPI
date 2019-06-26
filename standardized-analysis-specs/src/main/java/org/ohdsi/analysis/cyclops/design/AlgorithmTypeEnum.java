package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum AlgorithmTypeEnum {
    /**
     *
     */
    CCD("ccd"),
    /**
     *
     */
    MM("mm");

    private final String value;

    AlgorithmTypeEnum(String value) {
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
    public static AlgorithmTypeEnum fromValue(String text) {
        for (AlgorithmTypeEnum b : AlgorithmTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
