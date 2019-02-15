package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum CaliperScaleEnum {

    /**
     *
     */
    PROPENSITY_SCORE("propensity score"),
    /**
     *
     */
    STANDARDIZED("standardized"),
    /**
     *
     */
    STANDARDIZED_LOGIT("standardized logit");

    private final String value;

    CaliperScaleEnum(String value) {
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
    public static CaliperScaleEnum fromValue(String text) {
        for (CaliperScaleEnum b : CaliperScaleEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
