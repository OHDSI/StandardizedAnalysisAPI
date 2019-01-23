package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "estimationType")
public interface EstimationAnalysisSettings {

    /**
     *
     * @return
     */
    @JsonGetter("estimationType")
    EstimationTypeEnum getEstimationType();

    /**
     *
     * @param <T>
     * @return
     */
    @JsonGetter("analysisSpecification")
    <T extends Settings> T getAnalysisSpecification();
}
