package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum SelectorTypeEnum {
    /**
     *
     */
    BY_PID("byPid"),
    /**
     *
     */
    BY_ROW("byRow"),
    /**
     *
     */
    AUTO("auto");

    private final String value;

    SelectorTypeEnum(String value) {
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
    public static SelectorTypeEnum fromValue(String text) {
        for (SelectorTypeEnum b : SelectorTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

}
