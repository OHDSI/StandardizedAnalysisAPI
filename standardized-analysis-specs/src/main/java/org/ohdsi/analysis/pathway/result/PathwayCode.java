package org.ohdsi.analysis.pathway.result;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface PathwayCode {

    @JsonGetter("code")
    Integer getCode();

    @JsonGetter("name")
    String getName();
}
