package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "description" })
public interface CohortMetadata {

    @JsonGetter("id")
    Integer getId();

    @JsonGetter("name")
    String getName();
    
    @JsonGetter("description")
    String getDescription();
}
