package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Date;
import org.ohdsi.analysis.RLangClass;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface GetDbCohortMethodDataArgs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("studyStartDate")
    Date getStudyStartDate();

    /**
     *
     * @return
     */
    @JsonGetter("studyEndDate")
    Date getStudyEndDate();

    /**
     *
     * @return
     */
    @JsonGetter("excludeDrugsFromCovariates")
    Boolean getExcludeDrugsFromCovariates();

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
    @JsonGetter("removeDuplicateSubjects")
    RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects();

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
    @JsonGetter("maxCohortSize")
    Integer getMaxCohortSize();

    /**
     *
     * @return
     */
    @JsonGetter("covariateSettings")
    CovariateSettings getCovariateSettings();
}
