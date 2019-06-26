package org.ohdsi.analysis.pathway.result;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface PathwayPopulationEvent extends PathwayEvent {

    @JsonGetter("personCount")
    Integer getPersonCount();
}
