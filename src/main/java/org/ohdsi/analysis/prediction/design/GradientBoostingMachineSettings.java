package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import java.util.Collection;

public interface GradientBoostingMachineSettings extends SeedSettings {
  @JsonGetter("ntrees")
  Collection<BigDecimal> getNtrees();

  @JsonGetter("nthread")
  Integer getNthread();

  @JsonGetter("maxDepth")
  Collection<BigDecimal> getMaxDepth();

  @JsonGetter("minRows")
  Integer getMinRows();

  @JsonGetter("learnRate")
  Collection<Float> getLearnRate();
}
