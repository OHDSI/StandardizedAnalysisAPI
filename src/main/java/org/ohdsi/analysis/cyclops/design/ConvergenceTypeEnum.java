package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum ConvergenceTypeEnum {

    /**
     *
     */
    GRADIENT("gradient"),
    /**
     *
     */
    MITTAL("mittal"),
    /**
     *
     */
    LANGE("lange");

    private final String value;

    ConvergenceTypeEnum(String value) {
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
    public static ConvergenceTypeEnum fromValue(String text) {
        for (ConvergenceTypeEnum b : ConvergenceTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
