package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.estimation.design.Analysis;

public interface CohortMethodAnalysis extends Analysis {
  @JsonGetter("targetType")
  String getTargetType();

  @JsonGetter("comparatorType")
  String getComparatorType();

  @JsonGetter("getDbCohortMethodDataArgs")
  GetDbCohortMethodDataArgs getGetDbCohortMethodDataArgs();

  @JsonGetter("createStudyPopArgs")
  CreateStudyPopulationArgs getCreateStudyPopArgs();

  @JsonGetter("createPs")
  Boolean getCreatePs();

  @JsonGetter("createPsArgs")
  CreatePsArgs getCreatePsArgs();

  @JsonGetter("trimByPs")
  Boolean getTrimByPs();

  @JsonGetter("trimByPsArgs")
  TrimByPsArgs getTrimByPsArgs();

  @JsonGetter("trimByPsToEquipoise")
  Boolean getTrimByPsToEquipoise();

  @JsonGetter("trimByPsToEquipoiseArgs")
  TrimByPsToEquipoiseArgs getTrimByPsToEquipoiseArgs();

  @JsonGetter("matchOnPs")
  Boolean getMatchOnPs();

  @JsonGetter("matchOnPsArgs")
  MatchOnPsArgs getMatchOnPsArgs();

  @JsonGetter("matchOnPsAndCovariates")
  Boolean getMatchOnPsAndCovariates();

  @JsonGetter("matchOnPsAndCovariatesArgs")
  MatchOnPsAndCovariatesArgs getMatchOnPsAndCovariatesArgs();

  @JsonGetter("stratifyByPs")
  Boolean getStratifyByPs();

  @JsonGetter("stratifyByPsArgs")
  StratifyByPsArgs getStratifyByPsArgs();

  @JsonGetter("stratifyByPsAndCovariates")
  Boolean getStratifyByPsAndCovariates();

  @JsonGetter("stratifyByPsAndCovariatesArgs")
  StratifyByPsAndCovariatesArgs getStratifyByPsAndCovariatesArgs();

  @JsonGetter("fitOutcomeModel")
  Boolean getFitOutcomeModel();

  @JsonGetter("fitOutcomeModelArgs")
  FitOutcomeModelArgs getFitOutcomeModelArgs();
}
