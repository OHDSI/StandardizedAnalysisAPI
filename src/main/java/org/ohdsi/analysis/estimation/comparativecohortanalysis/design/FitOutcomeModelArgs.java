package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.Prior;

public interface FitOutcomeModelArgs {
  @JsonGetter("modelType")
  OutcomeModelTypeEnum getModelType();

  @JsonGetter("stratified")
  Boolean getStratified();

  @JsonGetter("useCovariates")
  Boolean getUseCovariates();

  @JsonGetter("inversePtWeighting")
  Boolean getInversePtWeighting();

  @JsonGetter("interactionCovariateIds")
  Collection<Integer> getInteractionCovariateIds();

  @JsonGetter("excludeCovariateIds")
  Collection<Integer> getExcludeCovariateIds();

  @JsonGetter("includeCovariateIds")
  Collection<Integer> getIncludeCovariateIds();

  @JsonGetter("prior")
  Prior getPrior();

  @JsonGetter("control")
  Control getControl();
}
