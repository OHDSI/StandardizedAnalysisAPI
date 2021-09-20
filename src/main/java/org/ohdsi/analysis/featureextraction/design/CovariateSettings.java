package org.ohdsi.analysis.featureextraction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface CovariateSettings extends RLangClass {

    @JsonGetter("temporal")
    Boolean getTemporal();

    @JsonGetter("DemographicsGender")
    Boolean getDemographicsGender();

    @JsonGetter("DemographicsAge")
    Boolean getDemographicsAge();

    @JsonGetter("DemographicsAgeGroup")
    Boolean getDemographicsAgeGroup();

    @JsonGetter("DemographicsRace")
    Boolean getDemographicsRace();

    @JsonGetter("DemographicsEthnicity")
    Boolean getDemographicsEthnicity();

    @JsonGetter("DemographicsIndexYear")
    Boolean getDemographicsIndexYear();

    @JsonGetter("DemographicsIndexMonth")
    Boolean getDemographicsIndexMonth();

    @JsonGetter("DemographicsPriorObservationTime")
    Boolean getDemographicsPriorObservationTime();

    @JsonGetter("DemographicsPostObservationTime")
    Boolean getDemographicsPostObservationTime();

    @JsonGetter("DemographicsTimeInCohort")
    Boolean getDemographicsTimeInCohort();

    @JsonGetter("DemographicsIndexYearMonth")
    Boolean getDemographicsIndexYearMonth();

    @JsonGetter("ConditionOccurrenceAnyTimePrior")
    Boolean getConditionOccurrenceAnyTimePrior();

    @JsonGetter("ConditionOccurrenceLongTerm")
    Boolean getConditionOccurrenceLongTerm();

    @JsonGetter("ConditionOccurrenceMediumTerm")
    Boolean getConditionOccurrenceMediumTerm();

    @JsonGetter("ConditionOccurrenceShortTerm")
    Boolean getConditionOccurrenceShortTerm();

    @JsonGetter("ConditionOccurrencePrimaryInpatientAnyTimePrior")
    Boolean getConditionOccurrencePrimaryInpatientAnyTimePrior();

    @JsonGetter("ConditionOccurrencePrimaryInpatientLongTerm")
    Boolean getConditionOccurrencePrimaryInpatientLongTerm();

    @JsonGetter("ConditionOccurrencePrimaryInpatientMediumTerm")
    Boolean getConditionOccurrencePrimaryInpatientMediumTerm();

    @JsonGetter("ConditionOccurrencePrimaryInpatientShortTerm")
    Boolean getConditionOccurrencePrimaryInpatientShortTerm();

    @JsonGetter("ConditionEraAnyTimePrior")
    Boolean getConditionEraAnyTimePrior();

    @JsonGetter("ConditionEraLongTerm")
    Boolean getConditionEraLongTerm();

    @JsonGetter("ConditionEraMediumTerm")
    Boolean getConditionEraMediumTerm();

    @JsonGetter("ConditionEraShortTerm")
    Boolean getConditionEraShortTerm();

    @JsonGetter("ConditionEraOverlapping")
    Boolean getConditionEraOverlapping();

    @JsonGetter("ConditionEraStartLongTerm")
    Boolean getConditionEraStartLongTerm();

    @JsonGetter("ConditionEraStartMediumTerm")
    Boolean getConditionEraStartMediumTerm();

    @JsonGetter("ConditionEraStartShortTerm")
    Boolean getConditionEraStartShortTerm();

    @JsonGetter("ConditionGroupEraAnyTimePrior")
    Boolean getConditionGroupEraAnyTimePrior();

    @JsonGetter("ConditionGroupEraLongTerm")
    Boolean getConditionGroupEraLongTerm();

    @JsonGetter("ConditionGroupEraMediumTerm")
    Boolean getConditionGroupEraMediumTerm();

    @JsonGetter("ConditionGroupEraShortTerm")
    Boolean getConditionGroupEraShortTerm();

    @JsonGetter("ConditionGroupEraOverlapping")
    Boolean getConditionGroupEraOverlapping();

    @JsonGetter("ConditionGroupEraStartLongTerm")
    Boolean getConditionGroupEraStartLongTerm();

    @JsonGetter("ConditionGroupEraStartMediumTerm")
    Boolean getConditionGroupEraStartMediumTerm();

    @JsonGetter("ConditionGroupEraStartShortTerm")
    Boolean getConditionGroupEraStartShortTerm();

    @JsonGetter("DrugExposureAnyTimePrior")
    Boolean getDrugExposureAnyTimePrior();

    @JsonGetter("DrugExposureLongTerm")
    Boolean getDrugExposureLongTerm();

    @JsonGetter("DrugExposureMediumTerm")
    Boolean getDrugExposureMediumTerm();

    @JsonGetter("DrugExposureShortTerm")
    Boolean getDrugExposureShortTerm();

    @JsonGetter("DrugEraAnyTimePrior")
    Boolean getDrugEraAnyTimePrior();

    @JsonGetter("DrugEraLongTerm")
    Boolean getDrugEraLongTerm();

    @JsonGetter("DrugEraMediumTerm")
    Boolean getDrugEraMediumTerm();

    @JsonGetter("DrugEraShortTerm")
    Boolean getDrugEraShortTerm();

    @JsonGetter("DrugEraOverlapping")
    Boolean getDrugEraOverlapping();

    @JsonGetter("DrugEraStartLongTerm")
    Boolean getDrugEraStartLongTerm();

    @JsonGetter("DrugEraStartMediumTerm")
    Boolean getDrugEraStartMediumTerm();

    @JsonGetter("DrugEraStartShortTerm")
    Boolean getDrugEraStartShortTerm();

    @JsonGetter("DrugGroupEraAnyTimePrior")
    Boolean getDrugGroupEraAnyTimePrior();

    @JsonGetter("DrugGroupEraLongTerm")
    Boolean getDrugGroupEraLongTerm();

    @JsonGetter("DrugGroupEraMediumTerm")
    Boolean getDrugGroupEraMediumTerm();

    @JsonGetter("DrugGroupEraShortTerm")
    Boolean getDrugGroupEraShortTerm();

    @JsonGetter("DrugGroupEraOverlapping")
    Boolean getDrugGroupEraOverlapping();

    @JsonGetter("DrugGroupEraStartLongTerm")
    Boolean getDrugGroupEraStartLongTerm();

    @JsonGetter("DrugGroupEraStartMediumTerm")
    Boolean getDrugGroupEraStartMediumTerm();

    @JsonGetter("DrugGroupEraStartShortTerm")
    Boolean getDrugGroupEraStartShortTerm();

    @JsonGetter("ProcedureOccurrenceAnyTimePrior")
    Boolean getProcedureOccurrenceAnyTimePrior();

    @JsonGetter("ProcedureOccurrenceLongTerm")
    Boolean getProcedureOccurrenceLongTerm();

    @JsonGetter("ProcedureOccurrenceMediumTerm")
    Boolean getProcedureOccurrenceMediumTerm();

    @JsonGetter("ProcedureOccurrenceShortTerm")
    Boolean getProcedureOccurrenceShortTerm();

    @JsonGetter("DeviceExposureAnyTimePrior")
    Boolean getDeviceExposureAnyTimePrior();

    @JsonGetter("DeviceExposureLongTerm")
    Boolean getDeviceExposureLongTerm();

    @JsonGetter("DeviceExposureMediumTerm")
    Boolean getDeviceExposureMediumTerm();

    @JsonGetter("DeviceExposureShortTerm")
    Boolean getDeviceExposureShortTerm();

    @JsonGetter("MeasurementAnyTimePrior")
    Boolean getMeasurementAnyTimePrior();

    @JsonGetter("MeasurementLongTerm")
    Boolean getMeasurementLongTerm();

    @JsonGetter("MeasurementMediumTerm")
    Boolean getMeasurementMediumTerm();

    @JsonGetter("MeasurementShortTerm")
    Boolean getMeasurementShortTerm();

    @JsonGetter("MeasurementValueAnyTimePrior")
    Boolean getMeasurementValueAnyTimePrior();

    @JsonGetter("MeasurementValueLongTerm")
    Boolean getMeasurementValueLongTerm();

    @JsonGetter("MeasurementValueMediumTerm")
    Boolean getMeasurementValueMediumTerm();

    @JsonGetter("MeasurementValueShortTerm")
    Boolean getMeasurementValueShortTerm();

    @JsonGetter("MeasurementRangeGroupAnyTimePrior")
    Boolean getMeasurementRangeGroupAnyTimePrior();

    @JsonGetter("MeasurementRangeGroupLongTerm")
    Boolean getMeasurementRangeGroupLongTerm();

    @JsonGetter("MeasurementRangeGroupMediumTerm")
    Boolean getMeasurementRangeGroupMediumTerm();

    @JsonGetter("MeasurementRangeGroupShortTerm")
    Boolean getMeasurementRangeGroupShortTerm();

    @JsonGetter("ObservationAnyTimePrior")
    Boolean getObservationAnyTimePrior();

    @JsonGetter("ObservationLongTerm")
    Boolean getObservationLongTerm();

    @JsonGetter("ObservationMediumTerm")
    Boolean getObservationMediumTerm();

    @JsonGetter("ObservationShortTerm")
    Boolean getObservationShortTerm();

    @JsonGetter("CharlsonIndex")
    Boolean getCharlsonIndex();

    @JsonGetter("Dcsi")
    Boolean getDcsi();

    @JsonGetter("Chads2")
    Boolean getChads2();

    @JsonGetter("Chads2Vasc")
    Boolean getChads2Vasc();

    @JsonGetter("DistinctConditionCountLongTerm")
    Boolean getDistinctConditionCountLongTerm();

    @JsonGetter("DistinctConditionCountMediumTerm")
    Boolean getDistinctConditionCountMediumTerm();

    @JsonGetter("DistinctConditionCountShortTerm")
    Boolean getDistinctConditionCountShortTerm();

    @JsonGetter("DistinctIngredientCountLongTerm")
    Boolean getDistinctIngredientCountLongTerm();

    @JsonGetter("DistinctIngredientCountMediumTerm")
    Boolean getDistinctIngredientCountMediumTerm();

    @JsonGetter("DistinctIngredientCountShortTerm")
    Boolean getDistinctIngredientCountShortTerm();

    @JsonGetter("DistinctProcedureCountLongTerm")
    Boolean getDistinctProcedureCountLongTerm();

    @JsonGetter("DistinctProcedureCountMediumTerm")
    Boolean getDistinctProcedureCountMediumTerm();

    @JsonGetter("DistinctProcedureCountShortTerm")
    Boolean getDistinctProcedureCountShortTerm();

    @JsonGetter("DistinctMeasurementCountLongTerm")
    Boolean getDistinctMeasurementCountLongTerm();

    @JsonGetter("DistinctMeasurementCountMediumTerm")
    Boolean getDistinctMeasurementCountMediumTerm();

    @JsonGetter("DistinctMeasurementCountShortTerm")
    Boolean getDistinctMeasurementCountShortTerm();

    @JsonGetter("DistinctObservationCountLongTerm")
    Boolean getDistinctObservationCountLongTerm();

    @JsonGetter("DistinctObservationCountMediumTerm")
    Boolean getDistinctObservationCountMediumTerm();

    @JsonGetter("DistinctObservationCountShortTerm")
    Boolean getDistinctObservationCountShortTerm();

    @JsonGetter("VisitCountLongTerm")
    Boolean getVisitCountLongTerm();

    @JsonGetter("VisitCountMediumTerm")
    Boolean getVisitCountMediumTerm();

    @JsonGetter("VisitCountShortTerm")
    Boolean getVisitCountShortTerm();

    @JsonGetter("VisitConceptCountLongTerm")
    Boolean getVisitConceptCountLongTerm();

    @JsonGetter("VisitConceptCountMediumTerm")
    Boolean getVisitConceptCountMediumTerm();

    @JsonGetter("VisitConceptCountShortTerm")
    Boolean getVisitConceptCountShortTerm();

    @JsonGetter("longTermStartDays")
    Integer getLongTermStartDays();

    @JsonGetter("mediumTermStartDays")
    Integer getMediumTermStartDays();

    @JsonGetter("shortTermStartDays")
    Integer getShortTermStartDays();

    @JsonGetter("endDays")
    Integer getEndDays();

    @JsonGetter("includedCovariateConceptIds")
    List<Long> getIncludedCovariateConceptIds();

    @JsonGetter("addDescendantsToInclude")
    Boolean getAddDescendantsToInclude();

    @JsonGetter("excludedCovariateConceptIds")
    List<Long> getExcludedCovariateConceptIds();

    @JsonGetter("addDescendantsToExclude")
    Boolean getAddDescendantsToExclude();

    @JsonGetter("includedCovariateIds")
    List<Long> getIncludedCovariateIds();

    @JsonGetter("attr_fun")
    String getAttrFun();
}
