package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.RLangClass;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.Prior;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface CreatePsArgs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("excludeCovariateIds")
    Collection<Integer> getExcludeCovariateIds();

    /**
     *
     * @return
     */
    @JsonGetter("includeCovariateIds")
    Collection<Integer> getIncludeCovariateIds();

    /**
     *
     * @return
     */
    @JsonGetter("maxCohortSizeForFitting")
    Integer getMaxCohortSizeForFitting();

    /**
     *
     * @return
     */
    @JsonGetter("errorOnHighCorrelation")
    Boolean getErrorOnHighCorrelation();

    /**
     *
     * @return
     */
    @JsonGetter("stopOnError")
    Boolean getStopOnError();

    /**
     *
     * @return
     */
    @JsonGetter("prior")
    Prior getPrior();

    /**
     *
     * @return
     */
    @JsonGetter("control")
    Control getControl();
}
