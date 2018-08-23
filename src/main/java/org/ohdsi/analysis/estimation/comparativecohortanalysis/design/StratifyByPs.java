package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface StratifyByPs {
  @JsonGetter("numberOfStrata")
  Integer getNumberOfStrata();
  
  @JsonGetter("baseSelection")
  BaseSelectionEnum getBaseSelection();
}
