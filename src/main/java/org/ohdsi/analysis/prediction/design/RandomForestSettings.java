package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import java.util.Collection;

public interface RandomForestSettings extends SeedSettings {
  @JsonGetter("mtries")
  Integer getMtries();

  @JsonGetter("ntrees")
  Integer getNtrees();

  @JsonGetter("maxDepth")
  Collection<BigDecimal> getMaxDepth();

  @JsonGetter("varImp")
  Boolean getVarImp();    
}
