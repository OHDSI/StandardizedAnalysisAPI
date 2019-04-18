package org.ohdsi.analysis.pathway.result;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Date;

public interface PathwayPersonEvent extends PathwayEvent {

    @JsonGetter("personId")
    Long getPersonId();

    @JsonGetter("startDate")
    Date getStartDate();

    @JsonGetter("endDate")
    Date getEndDate();
}
