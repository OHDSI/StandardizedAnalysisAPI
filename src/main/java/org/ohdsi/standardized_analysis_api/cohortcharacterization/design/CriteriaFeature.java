package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;

@JsonPropertyOrder({ "name", "criteriaGroup" })
public interface CriteriaFeature {

    @JsonGetter("name")
    String getName();

    @JsonGetter("criteriaGroup")
    CriteriaGroup getCriteriaGroup();
}