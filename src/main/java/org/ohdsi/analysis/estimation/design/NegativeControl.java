package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface NegativeControl {
  @JsonGetter("targetId")
  Long getTargetId();

  @JsonGetter("comparatorId")
  Long getComparatorId();

  @JsonGetter("outcomeId")
  Long getOutcomeId();

  @JsonGetter("outcomeName")
  String getOutcomeName();
  
  @JsonGetter("type")
  NegativeControlTypeEnum getType();
}
