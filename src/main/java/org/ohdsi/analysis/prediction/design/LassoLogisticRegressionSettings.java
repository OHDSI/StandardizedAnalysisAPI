package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface LassoLogisticRegressionSettings extends SeedSettings {
  @JsonGetter("variance")
  Float getVariance();
}
