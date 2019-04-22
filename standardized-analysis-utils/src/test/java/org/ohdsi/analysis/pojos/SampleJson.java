package org.ohdsi.analysis.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleJson extends BaseJson {

    @JsonProperty("name")
    String name;
    @JsonProperty("description")
    String description;
    @JsonProperty("count")
    Integer count;

    public static SampleJson newInstance() {

        return new SampleJson();
    }

    public SampleJson withName(String name) {

        this.name = name;
        return this;
    }

    public SampleJson withDescription(String description) {

        this.description = description;
        return this;
    }

    public SampleJson withCount(Integer count) {

        this.count = count;
        return this;
    }
}
