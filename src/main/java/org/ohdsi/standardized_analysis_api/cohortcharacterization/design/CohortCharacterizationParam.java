package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "value" })
public interface CohortCharacterizationParam {

    @JsonGetter("name")
    String getName();

    @JsonGetter("value")
    Object getValue();
}
