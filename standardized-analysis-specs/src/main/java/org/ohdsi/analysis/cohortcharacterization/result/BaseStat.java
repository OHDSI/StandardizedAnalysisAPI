package org.ohdsi.analysis.cohortcharacterization.result;

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
