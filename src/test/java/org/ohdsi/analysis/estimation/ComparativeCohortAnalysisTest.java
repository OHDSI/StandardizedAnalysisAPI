package org.ohdsi.analysis.estimation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.junit.Test;
import org.ohdsi.analysis.BaseTest;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.ConceptSetCrossReference;
import org.ohdsi.analysis.Utils;
import org.ohdsi.analysis.cyclops.design.Control;
import org.ohdsi.analysis.cyclops.design.Prior;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.BaseSelectionEnum;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.CaliperScaleEnum;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.CohortMethodAnalysis;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.ComparativeCohortAnalysis;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.CreatePsArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.CreateStudyPopulationArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.FitOutcomeModelArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.GetDbCohortMethodDataArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.MatchOnPsAndCovariatesArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.MatchOnPsArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.OutcomeModelTypeEnum;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.RemoveDuplicateSubjectsEnum;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.StratifyByPsAndCovariatesArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.StratifyByPsArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.TargetComparatorOutcomes;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.TrimByPsArgs;
import org.ohdsi.analysis.estimation.comparativecohortanalysis.design.TrimByPsToEquipoiseArgs;
import org.ohdsi.analysis.estimation.design.EstimationAnalysis;
import org.ohdsi.analysis.estimation.design.EstimationAnalysisSettings;
import org.ohdsi.analysis.estimation.design.EstimationTypeEnum;
import org.ohdsi.analysis.estimation.design.NegativeControl;
import org.ohdsi.analysis.estimation.design.NegativeControlExposureCohortExpression;
import org.ohdsi.analysis.estimation.design.NegativeControlOutcomeCohortExpression;
import org.ohdsi.analysis.estimation.design.NegativeControlTypeEnum;
import org.ohdsi.analysis.estimation.design.PositiveControlSynthesisArgs;
import org.ohdsi.analysis.estimation.design.PositiveControlSynthesisModelTypeEnum;
import org.ohdsi.analysis.estimation.design.Settings;
import org.ohdsi.analysis.hydra.design.SkeletonTypeEnum;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import org.ohdsi.circe.cohortdefinition.ConceptSet;
import org.ohdsi.circe.vocabulary.Concept;
import org.ohdsi.circe.vocabulary.ConceptSetExpression;
import org.skyscreamer.jsonassert.JSONAssert;


public class ComparativeCohortAnalysisTest extends BaseTest {
    
    @Test
    public void testComparativeCohortAnalysis() throws IOException, JSONException {
        EstimationAnalysis analysis = new EstimationAnalysis() {
            
            @Override
            public Integer getId() {
                return 1;
            }
            
            @Override
            public String getName() {
                return "Test";
            }
            
            @Override
            public String getDescription() {
                return null;
            }
            
            @Override
            public String getVersion() {
                return "Test";
            }
            
            @Override
            public String getOrganizationName() {
                return "OHDSI";
            }
            
            @Override
            public String getPackageName() {
                return "MyPackageNameGoesHere";
            }
            
            @Override
            public SkeletonTypeEnum getSkeletonType() {
                return SkeletonTypeEnum.COMPARATIVE_EFFECT_STUDY;
            }
            
            @Override
            public String getSkeletonVersion() {
                return "v0.0.1";
            }
            
            @Override
            public String getCreatedBy() {
                return null;
            }
            
            @Override
            public String getCreatedDate() {
                return null;
            }
            
            @Override
            public String getModifiedBy() {
                return null;
            }
            
            @Override
            public String getModifiedDate() {
                return null;
            }
            
            @Override
            public List<Cohort> getCohortDefinitions() {
                List<Cohort> returnVal = new ArrayList<>();
                returnVal.add(createTreatmentCohort());
                returnVal.add(createComparatorCohort());
                returnVal.add(createOutcomeCohort());
                return returnVal;
            }
            
            @Override
            public List<Object> getConceptSets() {
                List<Object> returnVal = new ArrayList<>();
                returnVal.add(createConceptSet());
                returnVal.add(createNegativeControlConceptSet());
                return returnVal;
            }
            
            @Override
            public Collection<ConceptSetCrossReference> getConceptSetCrossReference() {
                List<ConceptSetCrossReference> returnVal = new ArrayList<>();
                returnVal.add(createConceptSetCrossReference(1, "negativeControlOutcomes", 0, "outcomeId"));
                returnVal.add(createConceptSetCrossReference(0, "estimationAnalysisSettings.analysisSpecification.targetComparatorOutcomes", 0, "excludedCovariateConceptIds"));
                return returnVal;
            }
            
            @Override
            public Collection<NegativeControl> getNegativeControls() {
                List<NegativeControl> returnVal = new ArrayList<>();
                returnVal.add(createNegativeControl());
                return returnVal;
            }
            
            @Override
            public Boolean getDoPositiveControlSynthesis() {
                return true;
            }
            
            @Override
            public PositiveControlSynthesisArgs getPositiveControlSynthesisArgs() {
                return new PositiveControlSynthesisArgs() {
                    @Override
                    public Control getControl() {
                        return createControl();
                    }
                    @Override
                    public CovariateSettings getCovariateSettings() {
                        return createCovariateSettings();
                    }
                    @Override
                    public List<Float> getEffectSizes() {
                        ArrayList<Float> returnVal = new ArrayList<>();
                        returnVal.add(new Float(1.5));
                        returnVal.add(new Float(2));
                        returnVal.add(new Float(4));
                        return returnVal;
                    }
                    @Override
                    public Boolean getFirstExposureOnly() {
                        return true;
                    }
                    @Override
                    public Integer getMaxSubjectsForModel() {
                        return 250000;
                    }
                    @Override
                    public Integer getMinOutcomeCountForInjection() {
                        return 25;
                    }
                    @Override
                    public Integer getMinOutcomeCountForModel() {
                        return 50;
                    }
                    @Override
                    public PositiveControlSynthesisModelTypeEnum getModelType() {
                        return PositiveControlSynthesisModelTypeEnum.SURVIVAL;
                    }
                    @Override
                    public Integer getOutputIdOffset() {
                        return 10000;
                    }
                    @Override
                    public Float getPrecision() {
                        return new Float(0.01);
                    }
                    @Override
                    public Boolean getAddExposureDaysToEnd() {
                        return true;
                    }
                    @Override
                    public Boolean getFirstOutcomeOnly() {
                        return true;
                    }
                    @Override
                    public Boolean getRemovePeopleWithPriorOutcomes() {
                        return true;
                    }
                    @Override
                    public Prior getPrior() {
                        return createPrior();
                    }
                    @Override
                    public Integer getRiskWindowEnd() {
                        return 30;
                    }
                    @Override
                    public Integer getRiskWindowStart() {
                        return 0;
                    }
                    @Override
                    public Integer getWashoutPeriod() {
                        return 183;
                    }
                };
            }
            
            @Override
            public NegativeControlExposureCohortExpression getNegativeControlExposureCohortDefinition() {
                return new NegativeControlExposureCohortExpression() {};
            }
            
            @Override
            public NegativeControlOutcomeCohortExpression getNegativeControlOutcomeCohortDefinition() {
                return new NegativeControlOutcomeCohortExpression() {
                    @Override
                    public String getOccurrenceType() {
                        return "all";
                    }
                    
                    @Override
                    public Boolean getDetectOnDescendants() {
                        return true;
                    }
                    
                    @Override 
                    public List<String> getDomains() {
                        List<String> returnVal = new ArrayList<>();
                        returnVal.add("condition");
                        returnVal.add("procedure");
                        return returnVal;
                    }
                };
            }
            
            @Override
            public EstimationAnalysisSettings getEstimationAnalysisSettings() {
                return new EstimationAnalysisSettings() {
                    @Override
                    public EstimationTypeEnum getEstimationType() {
                        return EstimationTypeEnum.COMPARATIVE_COHORT_ANALYSIS;
                    }
                    
                    @Override
                    public Settings getAnalysisSpecification() {
                        return new ComparativeCohortAnalysis() {
                            @Override
                            public Collection<TargetComparatorOutcomes> getTargetComparatorOutcomes() {
                                Collection<TargetComparatorOutcomes> returnVal = new ArrayList<>();
                                returnVal.add(createTargetComparatorOutcomes());
                                return returnVal;
                            }
                            
                            @Override
                            public Collection<CohortMethodAnalysis> getCohortMethodAnalysisList() {
                                Collection<CohortMethodAnalysis> returnVal = new ArrayList<>();
                                returnVal.add(createCohortMethodAnalysis());
                                return returnVal;
                            }
                        };
                    }
                };
            }
        };
        //System.out.println(Utils.serializePretty(analysis, true));
        JSONAssert.assertEquals(readResource("/estimation/ComparativeCohortAnalysis.json"), Utils.serializePretty(analysis, true), false);
    }
    
    protected NegativeControl createNegativeControl() {
        return new NegativeControl() {
          @Override
          public Long getTargetId() {
              return new Long(createTreatmentCohort().getId());
          }
          
          @Override
          public Long getComparatorId() {
              return new Long(createComparatorCohort().getId());
          }
          
          @Override 
          public Long getOutcomeId() {
              return createNegativeControlConceptSet().expression.items[0].concept.conceptId;
          }
          
          @Override
          public String getOutcomeName() {
              return createNegativeControlConceptSet().expression.items[0].concept.conceptName;
          }
          
          @Override
          public NegativeControlTypeEnum getType() {
              return NegativeControlTypeEnum.OUTCOME;
          }
        };
    }
    
    /**
     * This will create a concept set for use with testing that 
     * matches the src/test/resources/estimation/NegativeControlConceptSet.json
     * definition.
     * @return
     */    
    protected ConceptSet createNegativeControlConceptSet() {
        ConceptSetExpression.ConceptSetItem ncConceptSetItem = new ConceptSetExpression.ConceptSetItem();
        ncConceptSetItem.includeDescendants = false;

        ncConceptSetItem.concept = new Concept();
        ncConceptSetItem.concept.conceptId = 4061734L;
        ncConceptSetItem.concept.conceptName = "Abscess of face";
        ncConceptSetItem.concept.standardConcept = "S";
        ncConceptSetItem.concept.invalidReason = "V";
        ncConceptSetItem.concept.conceptCode = "200751004";
        ncConceptSetItem.concept.domainId = "Condition";
        ncConceptSetItem.concept.vocabularyId = "SNOMED";
        ncConceptSetItem.concept.conceptClassId = "Clinical Finding";

        ConceptSet ncConceptSet = new ConceptSet();
        ncConceptSet.id = 1;
        ncConceptSet.name = "negative controls";
        ncConceptSet.expression = new ConceptSetExpression();
        ncConceptSet.expression.items = new ConceptSetExpression.ConceptSetItem[] { ncConceptSetItem };
        
        return ncConceptSet;
    }
    
    protected Cohort createTreatmentCohort() {
        return createCohort();
    }
    
    protected Cohort createComparatorCohort() {
        return createCohort(2, createCohort().getName());
    }
    
    protected Cohort createOutcomeCohort() {
        return createCohort(3, createCohort().getName());
    }
    
    protected TargetComparatorOutcomes createTargetComparatorOutcomes() {
        return new TargetComparatorOutcomes() {
          @Override
          public Long getTargetId() {
              return new Long(createTreatmentCohort().getId());
          }
          
          @Override
          public Long getComparatorId() {
              return new Long(createComparatorCohort().getId());
          }
          
          @Override
          public Collection<Long> getOutcomeIds() {
              Collection<Long> returnVal = new ArrayList<>();
              returnVal.add(new Long(createOutcomeCohort().getId()));
              return returnVal;
          }
          
          @Override 
          public Collection<Long> getExcludedCovariateConceptIds() {
              return new ArrayList<>();
          }
          
          @Override
          public Collection<Long> getIncludedCovariateConceptIds() {
              return new ArrayList<>();
          }
        };
    }
    
    protected CohortMethodAnalysis createCohortMethodAnalysis() {
        return new CohortMethodAnalysis() {
            @Override
            public Integer getAnalysisId() {
                return 1;
            }
            
            @Override 
            public String getDescription() {
                return "1-1 Matched cohort";
            }
            
            @Override
            public String getTargetType() { 
                return null;
            }
            
            @Override
            public String getComparatorType() {
                return null;
            }
            
            @Override 
            public GetDbCohortMethodDataArgs getDbCohortMethodDataArgs() {
                return new GetDbCohortMethodDataArgs() {
                    @Override
                    public Date getStudyStartDate() {
                        return null;
                    }
                    
                    @Override
                    public Date getStudyEndDate() {
                        return null;
                    }
                    
                    @Override
                    public Boolean getExcludeDrugsFromCovariates() {
                        return false;
                    }
                    
                    @Override
                    public Boolean getFirstExposureOnly() {
                        return true;
                    }
                    
                    @Override
                    public RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects() {
                        return RemoveDuplicateSubjectsEnum.KEEP_FIRST;
                    }
                    
                    @Override
                    public Boolean getRestrictToCommonPeriod() {
                        return false;
                    }
                    
                    @Override
                    public Integer getWashoutPeriod() {
                        return 180;
                    }
                    
                    @Override
                    public Integer getMaxCohortSize() {
                        return 0;
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                    
                    @Override
                    public CovariateSettings getCovariateSettings() {
                        return createCovariateSettings();
                    }
                };
            }
            
            @Override
            public CreateStudyPopulationArgs getCreateStudyPopArgs() {
                return new CreateStudyPopulationArgs() {
                    @Override
                    public Boolean getFirstExposureOnly() {
                        return false;
                    }
                    
                    @Override
                    public Boolean getRestrictToCommonPeriod() {
                        return false;
                    }
                    
                    @Override
                    public Integer getWashoutPeriod() {
                        return 0;
                    }
                    
                    @Override
                    public RemoveDuplicateSubjectsEnum getRemoveDuplicateSubjects() {
                        return RemoveDuplicateSubjectsEnum.KEEP_ALL;
                    }
                    
                    @Override
                    public Boolean getRemoveSubjectsWithPriorOutcome() {
                        return true;
                    }
                    
                    @Override
                    public Integer getPriorOutcomeLookback() {
                        return 99999;
                    }
                    
                    @Override
                    public Integer getMinDaysAtRisk() {
                        return 120;
                    }
                    
                    @Override
                    public Integer getRiskWindowStart() {
                        return 0;
                    }
                    
                    @Override
                    public Boolean getAddExposureDaysToStart() {
                        return false;
                    }
                    
                    @Override
                    public Integer getRiskWindowEnd() {
                        return 120;
                    }
                    
                    @Override
                    public Boolean getAddExposureDaysToEnd() {
                        return false;
                    }
                    
                    @Override
                    public Boolean getCensorAtNewRiskWindow() {
                        return false;
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getCreatePs() {
                return true;
            }
            
            @Override
            public CreatePsArgs getCreatePsArgs() {
                return new CreatePsArgs() {
                    @Override
                    public Collection<Integer> getExcludeCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public Collection<Integer> getIncludeCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public Integer getMaxCohortSizeForFitting() {
                        return 250000;
                    }
                    
                    @Override
                    public Boolean getErrorOnHighCorrelation() {
                        return true;
                    }
                    
                    @Override
                    public Boolean getStopOnError() {
                        return true;
                    }
                    
                    @Override
                    public Prior getPrior() {
                        return createPrior();
                    }
                    
                    @Override
                    public Control getControl() {
                        return createControl();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getTrimByPs() {
                return true;
            }
            
            @Override
            public TrimByPsArgs getTrimByPsArgs() {
                return new TrimByPsArgs() {
                    @Override
                    public Float getTrimFraction() {
                        return new Float(0.05);
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getTrimByPsToEquipoise() {
                return false;
            }
            
            @Override
            public TrimByPsToEquipoiseArgs getTrimByPsToEquipoiseArgs() {
                return new TrimByPsToEquipoiseArgs() {
                    @Override
                    public Collection<Float> getBounds() {
                        Collection<Float> returnVal = new ArrayList<>();
                        returnVal.add(new Float(0.25));
                        returnVal.add(new Float(0.75));
                        return returnVal;
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getMatchOnPs() {
                return true;
            }
            
            @Override
            public MatchOnPsArgs getMatchOnPsArgs() {
                return new MatchOnPsArgs() {
                    @Override
                    public Float getCaliper() {
                        return new Float(0.2);
                    }
                    
                    @Override
                    public CaliperScaleEnum getCaliperScale() {
                        return CaliperScaleEnum.STANDARDIZED_LOGIT;
                    }
                    
                    @Override
                    public Integer getMaxRatio() {
                        return 1;
                    }
                    
                    @Override
                    public Collection<String> getStratificationColumns() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getMatchOnPsAndCovariates() {
                return false;
            }
            
            @Override
            public MatchOnPsAndCovariatesArgs getMatchOnPsAndCovariatesArgs() {
                return new MatchOnPsAndCovariatesArgs() {
                    @Override
                    public Float getCaliper() {
                        return new Float(0.2);
                    }
                    
                    @Override
                    public CaliperScaleEnum getCaliperScale() {
                        return CaliperScaleEnum.STANDARDIZED_LOGIT;
                    }
                    
                    @Override
                    public Integer getMaxRatio() {
                        return 1;
                    }
                    
                    @Override
                    public Collection<Integer> getCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getStratifyByPs() {
                return false;
            }
            
            @Override
            public StratifyByPsArgs getStratifyByPsArgs() {
                return new StratifyByPsArgs() {
                    @Override
                    public Integer getNumberOfStrata() {
                        return 5;
                    }
                    
                    @Override
                    public BaseSelectionEnum getBaseSelection() {
                        return BaseSelectionEnum.ALL;
                    }
                    
                    @Override
                    public Collection<String> getStratificationColumns() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getStratifyByPsAndCovariates() {
                return false;
            }
            
            @Override
            public StratifyByPsAndCovariatesArgs getStratifyByPsAndCovariatesArgs() {
                return new StratifyByPsAndCovariatesArgs() {
                    @Override
                    public Integer getNumberOfStrata() {
                        return 5;
                    }
                    
                    @Override
                    public BaseSelectionEnum getBaseSelection() {
                        return BaseSelectionEnum.ALL;
                    }
                    
                    @Override
                    public Collection<Integer> getCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public Boolean getFitOutcomeModel() {
                return true;
            }
            
            @Override
            public FitOutcomeModelArgs getFitOutcomeModelArgs() {
                return new FitOutcomeModelArgs() {
                    @Override
                    public OutcomeModelTypeEnum getModelType() {
                        return OutcomeModelTypeEnum.COX;
                    }
                    
                    @Override
                    public Boolean getStratified() {
                        return true;
                    }
                    
                    @Override
                    public Boolean getUseCovariates() {
                        return false;
                    }
                    
                    @Override
                    public Boolean getInversePtWeighting() {
                        return false;
                    }
                    
                    @Override
                    public Collection<Integer> getInteractionCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public Collection<Integer> getExcludeCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public Collection<Integer> getIncludeCovariateIds() {
                        return new ArrayList<>();
                    }
                    
                    @Override
                    public Prior getPrior() {
                        return createPrior();
                    }
                    
                    @Override
                    public Control getControl() {
                        return createControl();
                    }
                    
                    @Override
                    public String getAttrClass() {
                        return "args";
                    }
                };
            }
            
            @Override
            public String getAttrClass() {
                return "cmAnalysis";
            }
        };
    }
}
