package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface MLPSettings {
  @JsonGetter("size")
  Integer getSize();
  
  @JsonGetter("alpha")
  Float getAlpha();
}
