package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * level of Cyclops screen output (\&quot;silent\&quot;, \&quot;quiet\&quot;,
 * \&quot;noisy\&quot;)
 */
public enum NoiseLevelEnum {

    /**
     *
     */
    SILENT("silent"),
    /**
     *
     */
    QUIET("quiet"),
    /**
     *
     */
    NOISY("noisy");

    private final String value;

    NoiseLevelEnum(String value) {
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
    public static NoiseLevelEnum fromValue(String text) {
        for (NoiseLevelEnum b : NoiseLevelEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
