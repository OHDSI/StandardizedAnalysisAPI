package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Date;
import org.ohdsi.analysis.RLangClass;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface GetDbCohortMethodDataArgs extends RLangClass {

    @JsonGetter("studyStartDate")
    Date getStudyStartDate();

    @JsonGetter("studyEndDate")
    Date getStudyEndDate();

    @JsonGetter("excludeDrugsFromCovariates")
    Boolean getExcludeDrugsFromCovariates();

    @JsonGetter("firstExposureOnly")
    Boolean getFirstExposureOnly();

    @JsonGetter("removeDuplicateSubjects")
    RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects();

    @JsonGetter("restrictToCommonPeriod")
    Boolean getRestrictToCommonPeriod();

    @JsonGetter("washoutPeriod")
    Integer getWashoutPeriod();

    @JsonGetter("maxCohortSize")
    Integer getMaxCohortSize();

    @JsonGetter("covariateSettings")
    CovariateSettings getCovariateSettings();
}
