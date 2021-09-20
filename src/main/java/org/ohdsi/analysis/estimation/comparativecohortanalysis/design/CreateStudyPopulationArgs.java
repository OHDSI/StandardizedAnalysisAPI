package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface CreateStudyPopulationArgs extends RLangClass {

    @JsonGetter("firstExposureOnly")
    Boolean getFirstExposureOnly();

    @JsonGetter("restrictToCommonPeriod")
    Boolean getRestrictToCommonPeriod();

    @JsonGetter("washoutPeriod")
    Integer getWashoutPeriod();

    @JsonGetter("removeDuplicateSubjects")
    RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects();

    @JsonGetter("removeSubjectsWithPriorOutcome")
    Boolean getRemoveSubjectsWithPriorOutcome();

    @JsonGetter("priorOutcomeLookback")
    Integer getPriorOutcomeLookback();

    @JsonGetter("minDaysAtRisk")
    Integer getMinDaysAtRisk();

    @JsonGetter("riskWindowStart")
    Integer getRiskWindowStart();

    @JsonGetter("addExposureDaysToStart")
    Boolean getAddExposureDaysToStart();

    @JsonGetter("riskWindowEnd")
    Integer getRiskWindowEnd();

    @JsonGetter("addExposureDaysToEnd")
    Boolean getAddExposureDaysToEnd();

    @JsonGetter("censorAtNewRiskWindow")
    Boolean getCensorAtNewRiskWindow();
}
