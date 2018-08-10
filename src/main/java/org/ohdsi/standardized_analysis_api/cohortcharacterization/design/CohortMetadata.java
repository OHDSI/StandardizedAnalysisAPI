package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "description" })
public interface CohortMetadata {

    @JsonGetter("name")
    String getName();
    
    @JsonGetter("description")
    String getDescription();
}
