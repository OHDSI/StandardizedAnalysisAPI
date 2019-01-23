package org.ohdsi.analysis;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.ohdsi.analysis.cyclops.design.AlgorithmTypeEnum;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.ConvergenceTypeEnum;
import org.ohdsi.analysis.cyclops.design.CvTypeEnum;
import org.ohdsi.analysis.cyclops.design.NoiseLevelEnum;
import org.ohdsi.analysis.cyclops.design.Prior;
import org.ohdsi.analysis.cyclops.design.PriorTypeEnum;
import org.ohdsi.analysis.cyclops.design.SelectorTypeEnum;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import org.ohdsi.circe.cohortdefinition.CohortExpression;
import org.ohdsi.circe.cohortdefinition.ConceptSet;
import org.ohdsi.circe.cohortdefinition.Criteria;
import org.ohdsi.circe.cohortdefinition.DrugExposure;
import org.ohdsi.circe.cohortdefinition.ObservationFilter;
import org.ohdsi.circe.cohortdefinition.Period;
import org.ohdsi.circe.cohortdefinition.PrimaryCriteria;
import org.ohdsi.circe.cohortdefinition.ResultLimit;
import org.ohdsi.circe.vocabulary.Concept;
import org.ohdsi.circe.vocabulary.ConceptSetExpression;

/**
 *
 * Base test
 */
public class BaseTest {

    /**
     * This will create a cohort for with a default name and ID
     * @see createCohort
     * @return Cohort
     */
    protected Cohort createCohort() {
        return BaseTest.this.createCohort(1, "clopidogrel test");
    }
    
    /**
     * This will create a cohort for use with testing that 
     * matches the src/test/resources/analysis/Cohort.json
     * definition. But allows for override of the id and name
     * @param id The id of the cohort
     * @param name The name of the cohort which will also be the description
     * @see getConceptSet#createConceptSet
     * @return Cohort
     */
    protected Cohort createCohort(Integer id, String name) {
        return new Cohort() {
            @Override
            public Integer getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getDescription() {
                return name;
            }

            @Override
            public CohortExpression getExpression() {

                CohortExpression clopidogrelExpression = new CohortExpression();
                ConceptSet clopidogrelConceptSet = createConceptSet();

                DrugExposure de = new DrugExposure();
                de.codesetId = 0;

                PrimaryCriteria primaryCriteria = new PrimaryCriteria();
                primaryCriteria.primaryLimit = new ResultLimit();
                primaryCriteria.observationWindow = new ObservationFilter();
                primaryCriteria.criteriaList = new Criteria[] { de };

                clopidogrelExpression.conceptSets = new ConceptSet[] { clopidogrelConceptSet };
                clopidogrelExpression.censoringCriteria = new Criteria[] {};
                clopidogrelExpression.censorWindow = new Period();
                clopidogrelExpression.primaryCriteria = primaryCriteria;

                return clopidogrelExpression;
            }
        };        
    }
    
    /**
     * This will create a concept set for use with testing that 
     * matches the src/test/resources/analysis/ConceptSet.json
     * definition.
     * @return ConceptSet
     */
    protected ConceptSet createConceptSet() {
        ConceptSetExpression.ConceptSetItem clopidogrelConceptSetItem = new ConceptSetExpression.ConceptSetItem();
        clopidogrelConceptSetItem.includeDescendants = true;

        clopidogrelConceptSetItem.concept = new Concept();
        clopidogrelConceptSetItem.concept.conceptId = 1322184L;
        clopidogrelConceptSetItem.concept.conceptName = "clopidogrel";
        clopidogrelConceptSetItem.concept.standardConcept = "S";
        clopidogrelConceptSetItem.concept.invalidReason = "V";
        clopidogrelConceptSetItem.concept.conceptCode = "32968";
        clopidogrelConceptSetItem.concept.domainId = "Drug";
        clopidogrelConceptSetItem.concept.vocabularyId = "RxNorm";
        clopidogrelConceptSetItem.concept.conceptClassId = "Ingredient";

        ConceptSet clopidogrelConceptSet = new ConceptSet();
        clopidogrelConceptSet.id = 0;
        clopidogrelConceptSet.name = "clopidogrel";
        clopidogrelConceptSet.expression = new ConceptSetExpression();
        clopidogrelConceptSet.expression.items = new ConceptSetExpression.ConceptSetItem[] { clopidogrelConceptSetItem };
        
        return clopidogrelConceptSet;
    }
    
    /**
     * This will create a concept set cross reference 
     * @param conceptSetId - The concept set id to set on the return object
     * @param targetName - The target name to set on the return object
     * @param targetIndex  - The target index to set on the return object
     * @param propertyName - The property name to set on the return object
     * @return ConceptSetCrossReference
     */
    protected ConceptSetCrossReference createConceptSetCrossReference(Integer conceptSetId, String targetName, Integer targetIndex, String propertyName) {
        return new ConceptSetCrossReference() {
            @Override
            public Integer getConceptSetId() {
                return conceptSetId;
            }

            @Override
            public String getTargetName() {
                return targetName;
            }

            @Override
            public Integer getTargetIndex() {
                return targetIndex;
            }

            @Override 
            public String getPropertyName() {
                return propertyName;
            }
        };
    }

    /**
     * This will create a covariate settings object 
     * for use with testing that matches the 
     * src/test/resources/analysis/CovariateSettings.json
     * definition.
     * @return CovariateSettings
     */
    protected CovariateSettings createCovariateSettings() {
        return new CovariateSettings() {
            @Override
            public Boolean getTemporal() {
                return false;
            }

            @Override
            public Boolean getDemographicsGender() {
                return true;
            }

            @Override
            public Boolean getDemographicsAge() {
                return false;
            }

            @Override
            public Boolean getDemographicsAgeGroup() {
                return true;
            }

            @Override
            public Boolean getDemographicsRace() {
                return true;
            }

            @Override
            public Boolean getDemographicsEthnicity() {
                return true;
            }

            @Override
            public Boolean getDemographicsIndexYear() {
                return true;
            }

            @Override
            public Boolean getDemographicsIndexMonth() {
                return true;
            }

            @Override
            public Boolean getDemographicsPriorObservationTime() {
                return false;
            }

            @Override
            public Boolean getDemographicsPostObservationTime() {
                return false;
            }

            @Override
            public Boolean getDemographicsTimeInCohort() {
                return false;
            }

            @Override
            public Boolean getDemographicsIndexYearMonth() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrenceAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrenceLongTerm() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrenceMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrenceShortTerm() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrencePrimaryInpatientAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrencePrimaryInpatientLongTerm() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrencePrimaryInpatientMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionOccurrencePrimaryInpatientShortTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getConditionEraLongTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraShortTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraOverlapping() {
                return false;
            }

            @Override
            public Boolean getConditionEraStartLongTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraStartMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionEraStartShortTerm() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraLongTerm() {
                return true;
            }

            @Override
            public Boolean getConditionGroupEraMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraShortTerm() {
                return true;
            }

            @Override
            public Boolean getConditionGroupEraOverlapping() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraStartLongTerm() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraStartMediumTerm() {
                return false;
            }

            @Override
            public Boolean getConditionGroupEraStartShortTerm() {
                return false;
            }

            @Override
            public Boolean getDrugExposureAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getDrugExposureLongTerm() {
                return false;
            }

            @Override
            public Boolean getDrugExposureMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDrugExposureShortTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getDrugEraLongTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraShortTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraOverlapping() {
                return false;
            }

            @Override
            public Boolean getDrugEraStartLongTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraStartMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDrugEraStartShortTerm() {
                return false;
            }

            @Override
            public Boolean getDrugGroupEraAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getDrugGroupEraLongTerm() {
                return true;
            }

            @Override
            public Boolean getDrugGroupEraMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDrugGroupEraShortTerm() {
                return true;
            }

            @Override
            public Boolean getDrugGroupEraOverlapping() {
                return true;
            }

            @Override
            public Boolean getDrugGroupEraStartLongTerm() {
                return false;
            }

            @Override
            public Boolean getDrugGroupEraStartMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDrugGroupEraStartShortTerm() {
                return false;
            }

            @Override
            public Boolean getProcedureOccurrenceAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getProcedureOccurrenceLongTerm() {
                return true;
            }

            @Override
            public Boolean getProcedureOccurrenceMediumTerm() {
                return false;
            }

            @Override
            public Boolean getProcedureOccurrenceShortTerm() {
                return true;
            }

            @Override
            public Boolean getDeviceExposureAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getDeviceExposureLongTerm() {
                return true;
            }

            @Override
            public Boolean getDeviceExposureMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDeviceExposureShortTerm() {
                return true;
            }

            @Override
            public Boolean getMeasurementAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getMeasurementLongTerm() {
                return true;
            }

            @Override
            public Boolean getMeasurementMediumTerm() {
                return false;
            }

            @Override
            public Boolean getMeasurementShortTerm() {
                return true;
            }

            @Override
            public Boolean getMeasurementValueAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getMeasurementValueLongTerm() {
                return false;
            }

            @Override
            public Boolean getMeasurementValueMediumTerm() {
                return false;
            }

            @Override
            public Boolean getMeasurementValueShortTerm() {
                return false;
            }

            @Override
            public Boolean getMeasurementRangeGroupAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getMeasurementRangeGroupLongTerm() {
                return true;
            }

            @Override
            public Boolean getMeasurementRangeGroupMediumTerm() {
                return false;
            }

            @Override
            public Boolean getMeasurementRangeGroupShortTerm() {
                return false;
            }

            @Override
            public Boolean getObservationAnyTimePrior() {
                return false;
            }

            @Override
            public Boolean getObservationLongTerm() {
                return true;
            }

            @Override
            public Boolean getObservationMediumTerm() {
                return false;
            }

            @Override
            public Boolean getObservationShortTerm() {
                return true;
            }

            @Override
            public Boolean getCharlsonIndex() {
                return true;
            }

            @Override
            public Boolean getDcsi() {
                return true;
            }

            @Override
            public Boolean getChads2() {
                return true;
            }

            @Override
            public Boolean getChads2Vasc() {
                return true;
            }

            @Override
            public Boolean getDistinctConditionCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctConditionCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctConditionCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctIngredientCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctIngredientCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctIngredientCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctProcedureCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctProcedureCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctProcedureCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctMeasurementCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctMeasurementCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctMeasurementCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctObservationCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctObservationCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getDistinctObservationCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getVisitCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getVisitCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getVisitCountShortTerm() {
                return false;
            }

            @Override
            public Boolean getVisitConceptCountLongTerm() {
                return false;
            }

            @Override
            public Boolean getVisitConceptCountMediumTerm() {
                return false;
            }

            @Override
            public Boolean getVisitConceptCountShortTerm() {
                return false;
            }

            @Override
            public Integer getLongTermStartDays() {
                return -365;
            }

            @Override
            public Integer getMediumTermStartDays() {
                return -180;
            }

            @Override
            public Integer getShortTermStartDays() {
                return -30;
            }

            @Override
            public Integer getEndDays() {
                return 0;
            }

            @Override
            public List<Long> getIncludedCovariateConceptIds() {
                return new ArrayList<>();
            }

            @Override
            public Boolean getAddDescendantsToInclude() {
                return false;
            }

            @Override
            public List<Long> getExcludedCovariateConceptIds() {
                return new ArrayList<>();
            }

            @Override
            public Boolean getAddDescendantsToExclude() {
                return false;
            }

            @Override
            public List<Integer> getIncludedCovariateIds() {
                return new ArrayList<>();
            }

            @Override
            public String getAttrFun() {
                return "getDbDefaultCovariateData";
            }

            @Override
            public String getAttrClass() {
                return "covariateSettings";
            }
        };
    }
    
    /**
     * This will create a prior object 
     * for use with testing that matches the 
     * src/test/resources/analysis/Prior.json
     * definition.
     * @return Prior
     */
    protected Prior createPrior() {
        return new Prior() {
            @Override
            public Collection<String> getExclude() {
                Collection<String> returnVal = new ArrayList<>();
                returnVal.add("0");
                return returnVal;
            }

            @Override
            public String getGraph() {
                return null;
            }

            @Override
            public Collection<String> getNeighborhood() {
                return null;
            }

            @Override
            public Boolean getUseCrossValidation() {
                return true;
            }

            @Override
            public Boolean getForceIntercept() {
                return false;
            }

            @Override
            public Collection<PriorTypeEnum> getPriorType() {
                Collection<PriorTypeEnum> returnVal = new ArrayList<>();
                returnVal.add(PriorTypeEnum.LAPLACE);
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getVariance() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(1));
                return returnVal;
            }
             
            @Override
            public String getAttrClass() {
                return "cyclopsPrior";
            }
        };
    }

    /**
     * This will create a control object 
     * for use with testing that matches the 
     * src/test/resources/analysis/Control.json
     * definition.
     * @return Control
     */
    public Control createControl() {
        return new Control() {
            @Override
            public AlgorithmTypeEnum getAlgorithm() {
                return AlgorithmTypeEnum.CCD;
            }
            @Override
            public ConvergenceTypeEnum getConvergenceType(){
                return ConvergenceTypeEnum.GRADIENT;
            }
            @Override
            public Integer getCvRepetitions() {
                return 10;
            }
            @Override
            public CvTypeEnum getCvType() {
                return CvTypeEnum.AUTO;
            }
            @Override
            public Integer getFold() {
                return 10;
            }
            @Override
            public Integer getGridSteps() {
                return 10;
            }
            @Override
            public BigDecimal getInitialBound() {
                return new BigDecimal(2);
            }
            @Override
            public BigDecimal getLowerLimit() {
                return new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
            @Override
            public Integer getMaxBoundCount() {
                return 5;
            }
            @Override
            public Boolean getAutoSearch() {
                return true;
            }
            @Override
            public Integer getMaxIterations() {
                return 1000;
            }
            @Override
            public Integer getMinCVData() {
                return 100;
            }
            @Override
            public NoiseLevelEnum getNoiseLevel() {
                return NoiseLevelEnum.SILENT;
            }
            @Override
            public Integer getSeed() {
                return null;
            }
            @Override
            public Boolean getResetCoefficients() {
                return false;
            }
            @Override
            public SelectorTypeEnum getSelectorType() {
                return SelectorTypeEnum.AUTO;
            }
            @Override
            public BigDecimal getStartingVariance() {
                return new BigDecimal(-1);
            }
            @Override
            public Boolean getUseKKTSwindle() {
                return false;
            }
            @Override
            public Integer getThreads() {
                return 1;
            }
            @Override
            public BigDecimal getTolerance() {
                return new BigDecimal(0.000001).setScale(6, BigDecimal.ROUND_HALF_UP);
            }
            @Override
            public Integer getTuneSwindle() {
                return 10;
            }
            @Override
            public BigDecimal getUpperLimit() {
                return new BigDecimal(20);
            }
            @Override
            public String getAttrClass() {
                return "cyclopsControl";
            }
        };
    }
    
    /**
     * Read the resource from the /src/test/resources folder
     * @param path
     * @return
     * @throws IOException
     */
    protected String readResource(String path) throws IOException {

        return IOUtils.toString(
                this.getClass().getResourceAsStream(path),
                "UTF-8"
        );
    }
}
