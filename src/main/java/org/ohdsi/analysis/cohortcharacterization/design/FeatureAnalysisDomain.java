package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface FeatureAnalysisDomain {

    @JsonGetter("name")
    String getName();
}
