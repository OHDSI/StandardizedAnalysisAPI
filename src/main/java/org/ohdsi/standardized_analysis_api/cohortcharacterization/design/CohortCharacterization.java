package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.ohdsi.circe.cohortdefinition.CohortExpression;

import java.util.List;

@JsonPropertyOrder({ "cohortExpressions", "featureAnalyses", "parameters" })
public interface CohortCharacterization {

    @JsonGetter("cohortExpressions")
    List<CohortExpression> getCohortExpressions();

    @JsonGetter("featureAnalyses")
    List<FeatureAnalysis> getFeatureAnalyses();

    @JsonGetter("parameters")
    List<CohortCharacterizationParam> getParameters();
}
