package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface RunPlpArgs {
  @JsonGetter("minCovariateFraction")
  Float getMinCovariateFraction();

  @JsonGetter("normalizeData")
  Boolean getNormalizeData();
  
  @JsonGetter("testSplit")
  TestSplitEnum getTestSplit();

  @JsonGetter("testFraction")
  Float getTestFraction();

  @JsonGetter("splitSeed")
  Float getSplitSeed();

  @JsonGetter("nfold")
  Integer getNfold();
}
