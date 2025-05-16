package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public enum NegativeControlTypeEnum {

    /**
     *
     */
    OUTCOME("outcome"),
    /**
     *
     */
    EXPOSURE("exposure");

    private final String value;

    NegativeControlTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static NegativeControlTypeEnum fromValue(String text) {
        for (NegativeControlTypeEnum b : NegativeControlTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
