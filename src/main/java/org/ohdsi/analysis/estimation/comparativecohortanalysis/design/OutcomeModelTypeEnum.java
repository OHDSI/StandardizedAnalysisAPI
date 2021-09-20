package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of outcome model that will be used. Possible values are
 * \&quot;logistic\&quot;, \&quot;poisson\&quot;, or \&quot;cox\&quot;.
 */
public enum OutcomeModelTypeEnum {

    /**
     *
     */
    LOGISTIC("logistic"),
    /**
     *
     */
    POISSON("poisson"),
    /**
     *
     */
    COX("cox");

    private final String value;

    OutcomeModelTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static OutcomeModelTypeEnum fromValue(String text) {
        for (OutcomeModelTypeEnum b : OutcomeModelTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
