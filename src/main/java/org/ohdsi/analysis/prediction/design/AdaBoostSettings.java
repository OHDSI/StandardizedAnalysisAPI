package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface AdaBoostSettings extends SeedSettings {
  @JsonGetter("nEstimators")
  Integer getNEstimators();
  
  @JsonGetter("learningRate")
  Integer getLearningRate();    
}
