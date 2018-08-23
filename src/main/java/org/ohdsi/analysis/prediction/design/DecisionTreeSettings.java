package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface DecisionTreeSettings extends SeedSettings {
  @JsonGetter("maxDepth")
  Integer getMaxDepth();

  @JsonGetter("minSampleSplit")
  Integer getMinSampleSplit();

  @JsonGetter("minSampleLeaf")
  Integer getMinSampleLeaf();

  @JsonGetter("minImpurityDecrease")
  Float getMinImpurityDecrease();

  @JsonGetter("classWeight")
  String getClassWeight();

  @JsonGetter("plot")
  Boolean getPlot();
}
