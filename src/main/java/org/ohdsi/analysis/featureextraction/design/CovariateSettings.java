package org.ohdsi.analysis.featureextraction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface CovariateSettings extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("temporal")
    Boolean getTemporal();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsGender")
    Boolean getDemographicsGender();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsAge")
    Boolean getDemographicsAge();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsAgeGroup")
    Boolean getDemographicsAgeGroup();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsRace")
    Boolean getDemographicsRace();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsEthnicity")
    Boolean getDemographicsEthnicity();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsIndexYear")
    Boolean getDemographicsIndexYear();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsIndexMonth")
    Boolean getDemographicsIndexMonth();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsPriorObservationTime")
    Boolean getDemographicsPriorObservationTime();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsPostObservationTime")
    Boolean getDemographicsPostObservationTime();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsTimeInCohort")
    Boolean getDemographicsTimeInCohort();

    /**
     *
     * @return
     */
    @JsonGetter("DemographicsIndexYearMonth")
    Boolean getDemographicsIndexYearMonth();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrenceAnyTimePrior")
    Boolean getConditionOccurrenceAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrenceLongTerm")
    Boolean getConditionOccurrenceLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrenceMediumTerm")
    Boolean getConditionOccurrenceMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrenceShortTerm")
    Boolean getConditionOccurrenceShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrencePrimaryInpatientAnyTimePrior")
    Boolean getConditionOccurrencePrimaryInpatientAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrencePrimaryInpatientLongTerm")
    Boolean getConditionOccurrencePrimaryInpatientLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrencePrimaryInpatientMediumTerm")
    Boolean getConditionOccurrencePrimaryInpatientMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionOccurrencePrimaryInpatientShortTerm")
    Boolean getConditionOccurrencePrimaryInpatientShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraAnyTimePrior")
    Boolean getConditionEraAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraLongTerm")
    Boolean getConditionEraLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraMediumTerm")
    Boolean getConditionEraMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraShortTerm")
    Boolean getConditionEraShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraOverlapping")
    Boolean getConditionEraOverlapping();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraStartLongTerm")
    Boolean getConditionEraStartLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraStartMediumTerm")
    Boolean getConditionEraStartMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionEraStartShortTerm")
    Boolean getConditionEraStartShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraAnyTimePrior")
    Boolean getConditionGroupEraAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraLongTerm")
    Boolean getConditionGroupEraLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraMediumTerm")
    Boolean getConditionGroupEraMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraShortTerm")
    Boolean getConditionGroupEraShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraOverlapping")
    Boolean getConditionGroupEraOverlapping();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraStartLongTerm")
    Boolean getConditionGroupEraStartLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraStartMediumTerm")
    Boolean getConditionGroupEraStartMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ConditionGroupEraStartShortTerm")
    Boolean getConditionGroupEraStartShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugExposureAnyTimePrior")
    Boolean getDrugExposureAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("DrugExposureLongTerm")
    Boolean getDrugExposureLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugExposureMediumTerm")
    Boolean getDrugExposureMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugExposureShortTerm")
    Boolean getDrugExposureShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraAnyTimePrior")
    Boolean getDrugEraAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraLongTerm")
    Boolean getDrugEraLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraMediumTerm")
    Boolean getDrugEraMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraShortTerm")
    Boolean getDrugEraShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraOverlapping")
    Boolean getDrugEraOverlapping();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraStartLongTerm")
    Boolean getDrugEraStartLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraStartMediumTerm")
    Boolean getDrugEraStartMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugEraStartShortTerm")
    Boolean getDrugEraStartShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraAnyTimePrior")
    Boolean getDrugGroupEraAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraLongTerm")
    Boolean getDrugGroupEraLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraMediumTerm")
    Boolean getDrugGroupEraMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraShortTerm")
    Boolean getDrugGroupEraShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraOverlapping")
    Boolean getDrugGroupEraOverlapping();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraStartLongTerm")
    Boolean getDrugGroupEraStartLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraStartMediumTerm")
    Boolean getDrugGroupEraStartMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DrugGroupEraStartShortTerm")
    Boolean getDrugGroupEraStartShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ProcedureOccurrenceAnyTimePrior")
    Boolean getProcedureOccurrenceAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ProcedureOccurrenceLongTerm")
    Boolean getProcedureOccurrenceLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ProcedureOccurrenceMediumTerm")
    Boolean getProcedureOccurrenceMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ProcedureOccurrenceShortTerm")
    Boolean getProcedureOccurrenceShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DeviceExposureAnyTimePrior")
    Boolean getDeviceExposureAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("DeviceExposureLongTerm")
    Boolean getDeviceExposureLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DeviceExposureMediumTerm")
    Boolean getDeviceExposureMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DeviceExposureShortTerm")
    Boolean getDeviceExposureShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementAnyTimePrior")
    Boolean getMeasurementAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementLongTerm")
    Boolean getMeasurementLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementMediumTerm")
    Boolean getMeasurementMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementShortTerm")
    Boolean getMeasurementShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementValueAnyTimePrior")
    Boolean getMeasurementValueAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementValueLongTerm")
    Boolean getMeasurementValueLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementValueMediumTerm")
    Boolean getMeasurementValueMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementValueShortTerm")
    Boolean getMeasurementValueShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementRangeGroupAnyTimePrior")
    Boolean getMeasurementRangeGroupAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementRangeGroupLongTerm")
    Boolean getMeasurementRangeGroupLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementRangeGroupMediumTerm")
    Boolean getMeasurementRangeGroupMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("MeasurementRangeGroupShortTerm")
    Boolean getMeasurementRangeGroupShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ObservationAnyTimePrior")
    Boolean getObservationAnyTimePrior();

    /**
     *
     * @return
     */
    @JsonGetter("ObservationLongTerm")
    Boolean getObservationLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ObservationMediumTerm")
    Boolean getObservationMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("ObservationShortTerm")
    Boolean getObservationShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("CharlsonIndex")
    Boolean getCharlsonIndex();

    /**
     *
     * @return
     */
    @JsonGetter("Dcsi")
    Boolean getDcsi();

    /**
     *
     * @return
     */
    @JsonGetter("Chads2")
    Boolean getChads2();

    /**
     *
     * @return
     */
    @JsonGetter("Chads2Vasc")
    Boolean getChads2Vasc();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctConditionCountLongTerm")
    Boolean getDistinctConditionCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctConditionCountMediumTerm")
    Boolean getDistinctConditionCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctConditionCountShortTerm")
    Boolean getDistinctConditionCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctIngredientCountLongTerm")
    Boolean getDistinctIngredientCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctIngredientCountMediumTerm")
    Boolean getDistinctIngredientCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctIngredientCountShortTerm")
    Boolean getDistinctIngredientCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctProcedureCountLongTerm")
    Boolean getDistinctProcedureCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctProcedureCountMediumTerm")
    Boolean getDistinctProcedureCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctProcedureCountShortTerm")
    Boolean getDistinctProcedureCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctMeasurementCountLongTerm")
    Boolean getDistinctMeasurementCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctMeasurementCountMediumTerm")
    Boolean getDistinctMeasurementCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctMeasurementCountShortTerm")
    Boolean getDistinctMeasurementCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctObservationCountLongTerm")
    Boolean getDistinctObservationCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctObservationCountMediumTerm")
    Boolean getDistinctObservationCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("DistinctObservationCountShortTerm")
    Boolean getDistinctObservationCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitCountLongTerm")
    Boolean getVisitCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitCountMediumTerm")
    Boolean getVisitCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitCountShortTerm")
    Boolean getVisitCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitConceptCountLongTerm")
    Boolean getVisitConceptCountLongTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitConceptCountMediumTerm")
    Boolean getVisitConceptCountMediumTerm();

    /**
     *
     * @return
     */
    @JsonGetter("VisitConceptCountShortTerm")
    Boolean getVisitConceptCountShortTerm();

    /**
     *
     * @return
     */
    @JsonGetter("longTermStartDays")
    Integer getLongTermStartDays();

    /**
     *
     * @return
     */
    @JsonGetter("mediumTermStartDays")
    Integer getMediumTermStartDays();

    /**
     *
     * @return
     */
    @JsonGetter("shortTermStartDays")
    Integer getShortTermStartDays();

    /**
     *
     * @return
     */
    @JsonGetter("endDays")
    Integer getEndDays();

    /**
     *
     * @return
     */
    @JsonGetter("includedCovariateConceptIds")
    List<Long> getIncludedCovariateConceptIds();

    /**
     *
     * @return
     */
    @JsonGetter("addDescendantsToInclude")
    Boolean getAddDescendantsToInclude();

    /**
     *
     * @return
     */
    @JsonGetter("excludedCovariateConceptIds")
    List<Long> getExcludedCovariateConceptIds();

    /**
     *
     * @return
     */
    @JsonGetter("addDescendantsToExclude")
    Boolean getAddDescendantsToExclude();

    /**
     *
     * @return
     */
    @JsonGetter("includedCovariateIds")
    List<Long> getIncludedCovariateIds();

    /**
     *
     * @return
     */
    @JsonGetter("attr_fun")
    String getAttrFun();
}
