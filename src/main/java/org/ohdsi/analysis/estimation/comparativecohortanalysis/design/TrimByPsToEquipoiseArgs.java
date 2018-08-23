package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

public interface TrimByPsToEquipoiseArgs {
  @JsonGetter("bounds")
  Collection<Float> getBounds();
}
