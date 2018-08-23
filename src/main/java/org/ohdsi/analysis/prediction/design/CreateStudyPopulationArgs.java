package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

public interface CreateStudyPopulationArgs extends RLangClass {
  @JsonGetter("binary")
  Boolean getBinary();

  @JsonGetter("includeAllOutcomes")
  Boolean getIncludeAllOutcomes();

  @JsonGetter("firstExposureOnly")
  Boolean getFirstExposureOnly();

  @JsonGetter("washoutPeriod")
  Integer getWashoutPeriod();

  @JsonGetter("removeSubjectsWithPriorOutcome")
  Boolean getRemoveSubjectsWithPriorOutcome();

  @JsonGetter("priorOutcomeLookback")
  Integer getPriorOutcomeLookback();

  @JsonGetter("requireTimeAtRisk")
  Boolean getRequireTimeAtRisk();

  @JsonGetter("minTimeAtRisk")
  Integer getMinTimeAtRisk();

  @JsonGetter("riskWindowStart")
  Integer getRiskWindowStart();

  @JsonGetter("addExposureDaysToStart")
  Boolean getAddExposureDaysToStart();

  @JsonGetter("riskWindowEnd")
  Integer getRiskWindowEnd();

  @JsonGetter("addExposureDaysToEnd")
  Boolean getAddExposureDaysToEnd();
}
