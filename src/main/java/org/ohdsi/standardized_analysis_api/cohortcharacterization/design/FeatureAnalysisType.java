package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface FeatureAnalysisType {

    @JsonGetter("name")
    String getName();
}
