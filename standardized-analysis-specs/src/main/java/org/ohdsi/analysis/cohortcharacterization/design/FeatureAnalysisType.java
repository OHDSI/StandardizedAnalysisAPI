package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface FeatureAnalysisType {

    @JsonGetter("name")
    String getName();
}
