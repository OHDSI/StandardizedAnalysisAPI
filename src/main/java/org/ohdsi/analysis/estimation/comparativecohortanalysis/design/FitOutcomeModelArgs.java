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
public interface FitOutcomeModelArgs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("modelType")
    OutcomeModelTypeEnum getModelType();

    /**
     *
     * @return
     */
    @JsonGetter("stratified")
    Boolean getStratified();

    /**
     *
     * @return
     */
    @JsonGetter("useCovariates")
    Boolean getUseCovariates();

    /**
     *
     * @return
     */
    @JsonGetter("inversePtWeighting")
    Boolean getInversePtWeighting();

    /**
     *
     * @return
     */
    @JsonGetter("interactionCovariateIds")
    Collection<Integer> getInteractionCovariateIds();

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
    @JsonGetter("prior")
    Prior getPrior();

    /**
     *
     * @return
     */
    @JsonGetter("control")
    Control getControl();
}
