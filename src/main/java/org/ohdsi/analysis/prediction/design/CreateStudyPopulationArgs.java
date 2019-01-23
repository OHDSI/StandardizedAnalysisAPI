package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface CreateStudyPopulationArgs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("binary")
    Boolean getBinary();

    /**
     *
     * @return
     */
    @JsonGetter("includeAllOutcomes")
    Boolean getIncludeAllOutcomes();

    /**
     *
     * @return
     */
    @JsonGetter("firstExposureOnly")
    Boolean getFirstExposureOnly();

    /**
     *
     * @return
     */
    @JsonGetter("washoutPeriod")
    Integer getWashoutPeriod();

    /**
     *
     * @return
     */
    @JsonGetter("removeSubjectsWithPriorOutcome")
    Boolean getRemoveSubjectsWithPriorOutcome();

    /**
     *
     * @return
     */
    @JsonGetter("priorOutcomeLookback")
    Integer getPriorOutcomeLookback();

    /**
     *
     * @return
     */
    @JsonGetter("requireTimeAtRisk")
    Boolean getRequireTimeAtRisk();

    /**
     *
     * @return
     */
    @JsonGetter("minTimeAtRisk")
    Integer getMinTimeAtRisk();

    /**
     *
     * @return
     */
    @JsonGetter("riskWindowStart")
    Integer getRiskWindowStart();

    /**
     *
     * @return
     */
    @JsonGetter("addExposureDaysToStart")
    Boolean getAddExposureDaysToStart();

    /**
     *
     * @return
     */
    @JsonGetter("riskWindowEnd")
    Integer getRiskWindowEnd();

    /**
     *
     * @return
     */
    @JsonGetter("addExposureDaysToEnd")
    Boolean getAddExposureDaysToEnd();
}
