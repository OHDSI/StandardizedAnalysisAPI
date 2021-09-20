package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.Prior;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface PositiveControlSynthesisArgs {

    /**
     * Get control
     *
     * @return control
     *
     */
    @JsonGetter(value = "control")
    Control getControl();

    /**
     * Get covariateSettings
     *
     * @return covariateSettings
     *
     */
    @JsonGetter(value = "covariateSettings")
    CovariateSettings getCovariateSettings();

    /**
     * A numeric vector of effect sizes that should be inserted.
     *
     * @return effectSizes
     *
     */
    @JsonGetter(value = "effectSizes")
    List<Float> getEffectSizes();

    /**
     * Should signals be injected only for the first exposure? (ie. assuming an
     * acute effect)
     *
     * @return firstExposureOnly
     *
     */
    @JsonGetter(value = "firstExposureOnly")
    Boolean getFirstExposureOnly();

    /**
     * Maximum number of people used to fit an outcome model.
     *
     * @return maxSubjectsForModel
     *
     */
    @JsonGetter(value = "maxSubjectsForModel")
    Integer getMaxSubjectsForModel();

    /**
     * Minimum number of outcome events required to inject a signal.
     *
     * @return minOutcomeCountForInjection
     *
     */
    @JsonGetter(value = "minOutcomeCountForInjection")
    Integer getMinOutcomeCountForInjection();

    /**
     * Minimum number of outcome events required to build a model.
     *
     * @return minOutcomeCountForModel
     *
     */
    @JsonGetter(value = "minOutcomeCountForModel")
    Integer getMinOutcomeCountForModel();

    /**
     * Can be either \&quot;poisson\&quot; or \&quot;survival\&quot;
     *
     * @return modelType
     *
     */
    @JsonGetter(value = "modelType")
    PositiveControlSynthesisModelTypeEnum getModelType();

    /**
     * What should be the first new outcome ID that is to be created?
     *
     * @return outputIdOffset
     *
     */
    @JsonGetter(value = "outputIdOffset")
    Integer getOutputIdOffset();

    /**
     * The allowed ratio between target and injected signal size.
     *
     * @return precision
     *
     */
    @JsonGetter(value = "precision")
    Float getPrecision();

    /**
     * Should length of exposure be added to the risk window?
     *
     * @return addExposureDaysToEnd
     *
     */
    @JsonGetter(value = "addExposureDaysToEnd")
    Boolean getAddExposureDaysToEnd();

    /**
     * Should only the first outcome per person be considered when modeling the
     * outcome?
     *
     * @return firstOutcomeOnly
     *
     */
    @JsonGetter(value = "firstOutcomeOnly")
    Boolean getFirstOutcomeOnly();

    /**
     * Remove people with prior outcomes?
     *
     * @return removePeopleWithPriorOutcomes
     *
     */
    @JsonGetter(value = "removePeopleWithPriorOutcomes")
    Boolean getRemovePeopleWithPriorOutcomes();

    /**
     * Get prior
     *
     * @return prior
     *
     */
    @JsonGetter(value = "prior")
    Prior getPrior();

    /**
     * The end of the risk window relative to the start of the exposure. Note
     * that typically the length of exposure is added to this number (when the
     * addExposureDaysToEnd parameter is set to TRUE).
     *
     * @return riskWindowEnd
     *
     */
    @JsonGetter(value = "riskWindowEnd")
    Integer getRiskWindowEnd();

    /**
     * The start of the risk window relative to the start of the exposure (in
     * days). When 0, risk is assumed to start on the first day of exposure.
     *
     * @return riskWindowStart
     *
     */
    @JsonGetter(value = "riskWindowStart")
    Integer getRiskWindowStart();

    /**
     * Number of days at the start of observation for which no signals will be
     * injected, but will be used to determine whether exposure or outcome is
     * the first one, and for extracting covariates to build the outcome model.
     *
     * @return washoutPeriod
     *
     */
    @JsonGetter(value = "washoutPeriod")
    Integer getWashoutPeriod();

}
