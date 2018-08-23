package org.ohdsi.analysis.prediction.design;

import org.ohdsi.analysis.ConceptSetCrossReference;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;
import java.util.Collection;

public interface PatientLevelPredictionAnalysis {
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

  @JsonGetter("packageName")
  String getPackageName();

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
  Collection<? extends Object> getCohortDefinitions();

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
  Collection<? extends Object> getModelSettings();

  @JsonGetter("getPlpDataArgs")
  GetDbPLPDataArgs getGetPlpDataArgs();

  @JsonGetter("runPlpArgs")
  RunPlpArgs getRunPlpArgs();    
}
