package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum PriorTypeEnum {

    /**
     *
     */
    NONE("none"),
    /**
     *
     */
    LAPLACE("laplace"),
    /**
     *
     */
    NORMAL("normal");

    private final String value;

    PriorTypeEnum(String value) {
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
    public static PriorTypeEnum fromValue(String text) {
        for (PriorTypeEnum b : PriorTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
