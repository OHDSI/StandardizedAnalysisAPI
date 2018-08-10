package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "type", "name", "domain", "descr", "design" })
public interface FeatureAnalysis {

    @JsonGetter("type")
    FeatureAnalysisType getType();

    @JsonGetter("name")
    String getName();

    @JsonGetter("domain")
    FeatureAnalysisDomain getDomain();

    @JsonGetter("descr")
    String getDescr();

    @JsonGetter("design")
    <T extends Object> T getDesign();
}
