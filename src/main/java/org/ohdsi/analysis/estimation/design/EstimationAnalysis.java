package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

public interface EstimationAnalysis {
    /**
     * Get cohortDefinitions
     * @param <T>
     * @return cohortDefinitions
     **/
    @JsonGetter(value = "cohortDefinitions")
    <T extends Object> T getCohortDefinitions();

    /**
     * Get conceptSetCrossReference
     * @param <T>
     * @return conceptSetCrossReference
     **/
    @JsonGetter(value = "conceptSetCrossReference")
    <T extends Object> T getConceptSetCrossReference();

    /**
     * Get conceptSets
     * @param <T>
     * @return conceptSets
     **/
    @JsonGetter(value = "conceptSets")
    <T extends Object> T getConceptSets();

    /**
     * The person who created the specification
     * @return createdBy
     **/
    @JsonGetter(value = "createdBy")
    String getCreatedBy();

    /**
     * The date and time the estimation was first saved
     * @return createdDate
     **/
    @JsonGetter(value = "createdDate")
    String getCreatedDate();

    /**
     * The description of the study
     * @return description
     **/
    @JsonGetter(value = "description")
    String getDescription();

    /**
     * Get estimationAnalysisSettings
     * @return estimationAnalysisSettings
     **/
    @JsonGetter(value = "estimationAnalysisSettings")
    <T extends EstimationAnalysisSettings> T getEstimationAnalysisSettings();

    /**
     * Identifier for the estimation specification
     * @return id
     **/
    @JsonGetter(value = "id")
    Integer getId();

    /**
     * The person who updated the specification
     * @return modifiedBy
     **/
    @JsonGetter(value = "modifiedBy")
    String getModifiedBy();

    /**
     * The date and time the estimation was last saved
     * @return modifiedDate
     **/
    @JsonGetter(value = "modifiedDate")
    String getModifiedDate();

    /**
     * Name for the estimation specification
     * @return name
     **/
    @JsonGetter(value = "name")
    String getName();

    /**
     * Get negativeControlExposureCohortDefinition
     * @param <T>
     * @return negativeControlExposureCohortDefinition
     **/
    @JsonGetter(value = "negativeControlExposureCohortDefinition")
    <T extends NegativeControlExposureCohortExpression> T getNegativeControlExposureCohortDefinition();

    /**
     * Get negativeControlOutcomeCohortDefinition
     * @param <T>
     * @return negativeControlOutcomeCohortDefinition
     **/
    @JsonGetter(value = "negativeControlOutcomeCohortDefinition")
    <T extends NegativeControlOutcomeCohortExpression> T getNegativeControlOutcomeCohortDefinition();

    /**
     * Get negativeControls
     * @return negativeControls
     **/
    @JsonGetter(value = "negativeControls")
    Collection<? extends NegativeControl> getNegativeControls();

    /**
     * The organization that produced the specification
     * @return organizationName
     **/
    @JsonGetter(value = "organizationName")
    String getOrganizationName();

    /**
     * The name of the R Package for execution
     * @return packageName
     **/
    @JsonGetter(value = "packageName")
    String getPackageName();

  /**
   * Get doPositiveControlSynthesis
   * @return doPositiveControlSynthesis
   **/    
    @JsonGetter(value = "doPositiveControlSynthesis")
    Boolean getDoPositiveControlSynthesis();

    /**
     * Get positiveControlSynthesisArgs
     * @return positiveControlSynthesisArgs
     **/
    @JsonGetter(value = "positiveControlSynthesisArgs")
    PositiveControlSynthesisArgs getPositiveControlSynthesisArgs();

    /**
     * The base skeleton R package
     * @return skeletonType
     **/
    @JsonGetter(value = "skeletonType")
    SkeletonTypeEnum getSkeletonType();

    /**
     * The corresponding skeleton version to use
     * @return skeletonVersion
     **/
    @JsonGetter(value = "skeletonVersion")
    String getSkeletonVersion();

    /**
     * Version number of the specification
     * @return version
     **/
    @JsonGetter(value = "version")
    String getVersion();
}
