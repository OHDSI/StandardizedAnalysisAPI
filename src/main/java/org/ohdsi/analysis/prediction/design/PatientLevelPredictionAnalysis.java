package org.ohdsi.analysis.prediction.design;

import org.ohdsi.analysis.hydra.design.SkeletonTypeEnum;
import org.ohdsi.analysis.ConceptSetCrossReference;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import java.util.Collection;
import org.ohdsi.analysis.Cohort;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface PatientLevelPredictionAnalysis {

    /**
     *
     * @return
     */
    @JsonGetter("id")
    Integer getId();

    /**
     *
     * @return
     */
    @JsonGetter("name")
    String getName();

    /**
     *
     * @return
     */
    @JsonGetter("description")
    String getDescription();

    /**
     *
     * @return
     */
    @JsonGetter("version")
    String getVersion();

    /**
     *
     * @return
     */
    @JsonGetter("organizationName")
    String getOrganizationName();

    /**
     *
     * @return
     */
    @JsonGetter("packageName")
    String getPackageName();

    /**
     *
     * @return
     */
    @JsonGetter("skeletonType")
    SkeletonTypeEnum getSkeletonType();

    /**
     *
     * @return
     */
    @JsonGetter("skeletonVersion")
    String getSkeletonVersion();

    /**
     *
     * @return
     */
    @JsonGetter("createdBy")
    String getCreatedBy();

    /**
     *
     * @return
     */
    @JsonGetter("createdDate")
    String getCreatedDate();

    /**
     *
     * @return
     */
    @JsonGetter("modifiedBy")
    String getModifiedBy();

    /**
     *
     * @return
     */
    @JsonGetter("modifiedDate")
    String getModifiedDate();

    /**
     *
     * @return
     */
    @JsonGetter("cohortDefinitions")
    Collection<? extends Cohort> getCohortDefinitions();

    /**
     *
     * @return
     */
    @JsonGetter("conceptSets")
    Collection<? extends Object> getConceptSets();

    /**
     *
     * @return
     */
    @JsonGetter("conceptSetCrossReference")
    Collection<? extends ConceptSetCrossReference> getConceptSetCrossReference();

    /**
     *
     * @return
     */
    @JsonGetter("targetIds")
    Collection<BigDecimal> getTargetIds();

    /**
     *
     * @return
     */
    @JsonGetter("outcomeIds")
    Collection<BigDecimal> getOutcomeIds();

    /**
     *
     * @return
     */
    @JsonGetter("covariateSettings")
    Collection<? extends CovariateSettings> getCovariateSettings();

    /**
     *
     * @return
     */
    @JsonGetter("populationSettings")
    Collection<? extends CreateStudyPopulationArgs> getPopulationSettings();

    /**
     *
     * @return
     */
    @JsonGetter("modelSettings")
    Collection<? extends ModelSettings> getModelSettings();

    /**
     *
     * @return
     */
    @JsonGetter("getPlpDataArgs")
    GetDbPLPDataArgs getPlpDataArgs();

    /**
     *
     * @return
     */
    @JsonGetter("runPlpArgs")
    RunPlpArgs getRunPlpArgs();
}
