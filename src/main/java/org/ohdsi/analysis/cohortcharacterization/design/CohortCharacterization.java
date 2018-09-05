package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collection;

import org.ohdsi.analysis.Cohort;

@JsonPropertyOrder({ "cohorts", "featureAnalyses", "parameters" })
public interface CohortCharacterization {

    @JsonGetter("cohorts")
    Collection<? extends Cohort> getCohorts();

    @JsonGetter("featureAnalyses")
    Collection<? extends FeatureAnalysis> getFeatureAnalyses();

    @JsonGetter("parameters")
    Collection<? extends CohortCharacterizationParam> getParameters();
}
