package org.ohdsi.analysis.prediction.design;

import org.ohdsi.analysis.hydra.design.SkeletonTypeEnum;
import org.ohdsi.analysis.ConceptSetCrossReference;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import java.util.Collection;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.StudyPackage;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface PatientLevelPredictionAnalysis extends StudyPackage {

    @JsonGetter("id")
    Integer getId();

    @JsonGetter("name")
    String getName();

    @JsonGetter("description")
    String getDescription();

    @JsonGetter("version")
    String getVersion();

    @JsonGetter("organizationName")
    String getOrganizationName();

    @JsonGetter("skeletonType")
    SkeletonTypeEnum getSkeletonType();

    @JsonGetter("skeletonVersion")
    String getSkeletonVersion();

    @JsonGetter("createdBy")
    String getCreatedBy();

    @JsonGetter("createdDate")
    String getCreatedDate();

    @JsonGetter("modifiedBy")
    String getModifiedBy();

    @JsonGetter("modifiedDate")
    String getModifiedDate();

    @JsonGetter("cohortDefinitions")
    Collection<? extends Cohort> getCohortDefinitions();

    @JsonGetter("conceptSets")
    Collection<? extends Object> getConceptSets();

    @JsonGetter("conceptSetCrossReference")
    Collection<? extends ConceptSetCrossReference> getConceptSetCrossReference();

    @JsonGetter("targetIds")
    Collection<BigDecimal> getTargetIds();

    @JsonGetter("outcomeIds")
    Collection<BigDecimal> getOutcomeIds();

    @JsonGetter("covariateSettings")
    Collection<? extends CovariateSettings> getCovariateSettings();

    @JsonGetter("populationSettings")
    Collection<? extends CreateStudyPopulationArgs> getPopulationSettings();

    @JsonGetter("modelSettings")
    Collection<? extends ModelSettings> getModelSettings();

    @JsonGetter("getPlpDataArgs")
    GetDbPLPDataArgs getPlpDataArgs();

    @JsonGetter("runPlpArgs")
    RunPlpArgs getRunPlpArgs();
}
