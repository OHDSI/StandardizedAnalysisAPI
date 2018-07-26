package org.ohdsi.standardized_analysis_api.cohortcharacterization.result;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "covariateId", "covariateName", "conceptId", "count", "proportion" })
public interface PrevalenceStat extends BaseStat {

    @JsonGetter("proportion")
    Double getProportion();
}
