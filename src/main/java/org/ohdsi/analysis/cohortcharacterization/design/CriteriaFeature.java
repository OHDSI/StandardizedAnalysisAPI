package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;

@JsonPropertyOrder({ "name", "criteriaGroup" })
public interface CriteriaFeature {

    @JsonGetter("name")
    String getName();

    @JsonGetter("expression")
    CriteriaGroup getExpression();
}