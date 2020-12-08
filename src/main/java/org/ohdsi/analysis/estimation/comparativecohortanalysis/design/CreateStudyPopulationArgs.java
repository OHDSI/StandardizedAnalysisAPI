package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

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
    @JsonGetter("firstExposureOnly")
    Boolean getFirstExposureOnly();

    /**
     *
     * @return
     */
    @JsonGetter("restrictToCommonPeriod")
    Boolean getRestrictToCommonPeriod();

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
    @JsonGetter("removeDuplicateSubjects")
    RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects();

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
    @JsonGetter("minDaysAtRisk")
    Integer getMinDaysAtRisk();

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

    /**
     *
     * @return
     */
    @JsonGetter("censorAtNewRiskWindow")
    Boolean getCensorAtNewRiskWindow();
}
