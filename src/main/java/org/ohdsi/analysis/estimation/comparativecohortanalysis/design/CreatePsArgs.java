package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.RLangClass;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.Prior;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface CreatePsArgs extends RLangClass {

    @JsonGetter("excludeCovariateIds")
    Collection<Integer> getExcludeCovariateIds();

    @JsonGetter("includeCovariateIds")
    Collection<Integer> getIncludeCovariateIds();

    @JsonGetter("maxCohortSizeForFitting")
    Integer getMaxCohortSizeForFitting();

    @JsonGetter("errorOnHighCorrelation")
    Boolean getErrorOnHighCorrelation();

    @JsonGetter("stopOnError")
    Boolean getStopOnError();

    @JsonGetter("prior")
    Prior getPrior();

    @JsonGetter("control")
    Control getControl();
}
