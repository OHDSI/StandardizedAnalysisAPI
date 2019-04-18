package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.estimation.design.Analysis;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface CohortMethodAnalysis extends Analysis {

    /**
     *
     * @return
     */
    @JsonGetter("targetType")
    String getTargetType();

    /**
     *
     * @return
     */
    @JsonGetter("comparatorType")
    String getComparatorType();

    /**
     *
     * @return
     */
    @JsonGetter("getDbCohortMethodDataArgs")
    GetDbCohortMethodDataArgs getDbCohortMethodDataArgs();

    /**
     *
     * @return
     */
    @JsonGetter("createStudyPopArgs")
    CreateStudyPopulationArgs getCreateStudyPopArgs();

    /**
     *
     * @return
     */
    @JsonGetter("createPs")
    Boolean getCreatePs();

    /**
     *
     * @return
     */
    @JsonGetter("createPsArgs")
    CreatePsArgs getCreatePsArgs();

    /**
     *
     * @return
     */
    @JsonGetter("trimByPs")
    Boolean getTrimByPs();

    /**
     *
     * @return
     */
    @JsonGetter("trimByPsArgs")
    TrimByPsArgs getTrimByPsArgs();

    /**
     *
     * @return
     */
    @JsonGetter("trimByPsToEquipoise")
    Boolean getTrimByPsToEquipoise();

    /**
     *
     * @return
     */
    @JsonGetter("trimByPsToEquipoiseArgs")
    TrimByPsToEquipoiseArgs getTrimByPsToEquipoiseArgs();

    /**
     *
     * @return
     */
    @JsonGetter("matchOnPs")
    Boolean getMatchOnPs();

    /**
     *
     * @return
     */
    @JsonGetter("matchOnPsArgs")
    MatchOnPsArgs getMatchOnPsArgs();

    /**
     *
     * @return
     */
    @JsonGetter("matchOnPsAndCovariates")
    Boolean getMatchOnPsAndCovariates();

    /**
     *
     * @return
     */
    @JsonGetter("matchOnPsAndCovariatesArgs")
    MatchOnPsAndCovariatesArgs getMatchOnPsAndCovariatesArgs();

    /**
     *
     * @return
     */
    @JsonGetter("stratifyByPs")
    Boolean getStratifyByPs();

    /**
     *
     * @return
     */
    @JsonGetter("stratifyByPsArgs")
    StratifyByPsArgs getStratifyByPsArgs();

    /**
     *
     * @return
     */
    @JsonGetter("stratifyByPsAndCovariates")
    Boolean getStratifyByPsAndCovariates();

    /**
     *
     * @return
     */
    @JsonGetter("stratifyByPsAndCovariatesArgs")
    StratifyByPsAndCovariatesArgs getStratifyByPsAndCovariatesArgs();

    /**
     *
     * @return
     */
    @JsonGetter("fitOutcomeModel")
    Boolean getFitOutcomeModel();

    /**
     *
     * @return
     */
    @JsonGetter("fitOutcomeModelArgs")
    FitOutcomeModelArgs getFitOutcomeModelArgs();
}
