package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Can be either \&quot;poisson\&quot; or \&quot;survival\&quot;
 */
public enum PositiveControlSynthesisModelTypeEnum {

    /**
     *
     */
    POISSON("poisson"),
    /**
     *
     */
    SURVIVAL("survival");

    private final String value;

    PositiveControlSynthesisModelTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PositiveControlSynthesisModelTypeEnum fromValue(String text) {
        for (PositiveControlSynthesisModelTypeEnum b : PositiveControlSynthesisModelTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
