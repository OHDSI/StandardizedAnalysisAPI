package org.ohdsi.analysis.pathway.result;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface PathwayEvent {

    @JsonGetter("path")
    String getPath();
}
