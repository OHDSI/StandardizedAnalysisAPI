package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public enum EstimationTypeEnum {

    /**
     *
     */
    COMPARATIVE_COHORT_ANALYSIS(EstimationAnalysisConst.COMPARATIVE_COHORT_ANALYSIS);

    private final String value;

    EstimationTypeEnum(String value) {
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
    public static EstimationTypeEnum fromValue(String text) {
        for (EstimationTypeEnum b : EstimationTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
