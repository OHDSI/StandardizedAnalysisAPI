package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

public interface TargetOutcome {
  @JsonGetter("targetId")
  Long getTargetId();

  @JsonGetter("outcomeIds")
  Collection<Long> getOutcomeIds();
}
