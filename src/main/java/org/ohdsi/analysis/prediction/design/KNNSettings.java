package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface KNNSettings {
  @JsonGetter("k")
  Integer getK();
}
