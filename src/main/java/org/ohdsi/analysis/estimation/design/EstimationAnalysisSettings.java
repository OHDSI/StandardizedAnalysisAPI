package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "estimationType")
public interface EstimationAnalysisSettings {

    @JsonGetter("estimationType")
    EstimationTypeEnum getEstimationType();

    @JsonGetter("analysisSpecification")
    <T extends Settings> T getAnalysisSpecification();
}
