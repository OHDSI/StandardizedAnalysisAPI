package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * List of algorithms as defined in 
 * Cyclops http://ohdsi.github.io/Cyclops/
 * @author Anthony Sena sena@ohdsi.org
 */
public enum AlgorithmTypeEnum {
    /**
     * Name of fitting algorithm to employ
     */
    CCD("ccd"),
    /**
     * Name of fitting algorithm to employ
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
