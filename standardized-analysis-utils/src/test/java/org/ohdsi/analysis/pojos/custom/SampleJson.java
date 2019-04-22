package org.ohdsi.analysis.pojos.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleJson extends org.ohdsi.analysis.pojos.SampleJson {

    @JsonProperty("customField")
    Integer customField;

    public Integer getCustomField() {

        return customField;
    }
}
