package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface MatchOnPs {
  @JsonGetter("caliper")
  Float getCaliper();

  @JsonGetter("caliperScale")
  CaliperScaleEnum getCaliperScale();

  @JsonGetter("maxRatio")
  Integer getMaxRatio();    
}
