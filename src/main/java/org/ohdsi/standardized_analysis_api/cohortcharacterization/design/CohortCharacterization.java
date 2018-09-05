package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collection;

import org.ohdsi.standardized_analysis_api.Cohort;

@JsonPropertyOrder({ "cohorts", "featureAnalyses", "parameters" })
public interface CohortCharacterization {

    @JsonGetter("cohorts")
    Collection<? extends Cohort> getCohorts();

    @JsonGetter("featureAnalyses")
    Collection<? extends FeatureAnalysis> getFeatureAnalyses();

    @JsonGetter("parameters")
    Collection<? extends CohortCharacterizationParam> getParameters();
}
