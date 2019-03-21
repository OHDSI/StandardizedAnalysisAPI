package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collection;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.circe.cohortdefinition.ConceptSet;

@JsonPropertyOrder({ "name", "cohorts", "featureAnalyses", "parameters", "stratas", "strataOnly", "strataConceptSets" })
public interface CohortCharacterization {

    @JsonGetter("name")
    String getName();

    @JsonGetter("cohorts")
    Collection<? extends Cohort> getCohorts();

    @JsonGetter("featureAnalyses")
    Collection<? extends FeatureAnalysis> getFeatureAnalyses();

    @JsonGetter("parameters")
    Collection<? extends CohortCharacterizationParam> getParameters();

    @JsonGetter("stratas")
    Collection<? extends CohortCharacterizationStrata> getStratas();

    @JsonGetter("strataOnly")
    Boolean getStrataOnly();

    @JsonGetter("strataConceptSets")
    Collection<ConceptSet> getStrataConceptSets();
}
