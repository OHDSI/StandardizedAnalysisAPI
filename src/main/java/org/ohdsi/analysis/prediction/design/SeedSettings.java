package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface SeedSettings {
    @JsonGetter("seed")
    Float getSeed();
}
