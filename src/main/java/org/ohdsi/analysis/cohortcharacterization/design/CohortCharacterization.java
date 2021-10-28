package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collection;
import java.util.Collections;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.WithId;
import org.ohdsi.circe.cohortdefinition.ConceptSet;

@JsonPropertyOrder({ "id", "name", "cohorts", "featureAnalyses", "parameters", "stratas", "strataOnly", "strataConceptSets" })
public interface CohortCharacterization extends WithId<Long> {

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
    default Boolean getStrataOnly() {
        return false;
    }

    @JsonGetter("strataConceptSets")
    default Collection<ConceptSet> getStrataConceptSets() {
        return Collections.emptyList();
    }
}
