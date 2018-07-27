package org.ohdsi.standardized_analysis_api.cohortcharacterization.result;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface BaseStat {

    @JsonGetter("covariateId")
    Long getCovariateId();

    @JsonGetter("covariateName")
    String getCovariateName();

    @JsonGetter("conceptId")
    Long getConceptId();

    @JsonGetter("count")
    Long getCount();
}
