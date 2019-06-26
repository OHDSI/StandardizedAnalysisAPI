package org.ohdsi.analysis.prediction;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.junit.Test;
import org.ohdsi.analysis.BaseTest;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.ConceptSetCrossReference;
import org.ohdsi.analysis.Utils;
import org.ohdsi.analysis.featureextraction.design.CovariateSettings;
import org.ohdsi.analysis.prediction.design.AdaBoostSettings;
import org.ohdsi.analysis.prediction.design.ClassWeightEnum;
import org.ohdsi.analysis.prediction.design.CreateStudyPopulationArgs;
import org.ohdsi.analysis.prediction.design.DecisionTreeSettings;
import org.ohdsi.analysis.prediction.design.GetDbPLPDataArgs;
import org.ohdsi.analysis.prediction.design.GradientBoostingMachineSettings;
import org.ohdsi.analysis.prediction.design.KNNSettings;
import org.ohdsi.analysis.prediction.design.LassoLogisticRegressionSettings;
import org.ohdsi.analysis.prediction.design.MLPSettings;
import org.ohdsi.analysis.prediction.design.ModelSettings;
import org.ohdsi.analysis.prediction.design.NaiveBayesSettings;
import org.ohdsi.analysis.hydra.design.SkeletonTypeEnum;
import org.ohdsi.analysis.prediction.design.PatientLevelPredictionAnalysis;
import org.ohdsi.analysis.prediction.design.RandomForestSettings;
import org.ohdsi.analysis.prediction.design.RunPlpArgs;
import org.ohdsi.analysis.prediction.design.TestSplitEnum;
import org.skyscreamer.jsonassert.JSONAssert;

public class PredictionTest extends BaseTest {

    @Test
    public void testPatientLevelPredictionAnalysis() throws IOException, JSONException {
        PatientLevelPredictionAnalysis analysis = new PatientLevelPredictionAnalysis() {
            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getName() {
                return "Patient Level Prediction Study";
            }

            @Override
            public String getDescription() {
                return "Patient Level Prediction Study";
            }

            @Override
            public String getVersion() {
                return "v2.6.0";
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
                return SkeletonTypeEnum.PATIENT_LEVEL_PREDICTION_STUDY;
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
            public Collection<Cohort> getCohortDefinitions() {
                Collection<Cohort> returnVal = new ArrayList<>();
                returnVal.add(createCohort(1, "T"));
                returnVal.add(createCohort(2, "O"));
                return returnVal;
            }

            @Override
            public Collection<Object> getConceptSets() {
                Collection<Object> returnVal = new ArrayList<>();
                returnVal.add(createConceptSet());
                return returnVal;
            }

            @Override
            public Collection<ConceptSetCrossReference> getConceptSetCrossReference() {
                List<ConceptSetCrossReference> returnVal = new ArrayList<>();
                returnVal.add(createConceptSetCrossReference(0, "covariateSettings", 0, "includedCovariateConceptIds"));
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getTargetIds() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(1));
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getOutcomeIds() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(2));
                return returnVal;
            }

            @Override
            public Collection<CovariateSettings> getCovariateSettings() {
                Collection<CovariateSettings> returnVal = new ArrayList<>();
                returnVal.add(createCovariateSettings());
                return returnVal;
            }

            @Override
            public Collection<CreateStudyPopulationArgs> getPopulationSettings() {
                Collection<CreateStudyPopulationArgs> returnVal = new ArrayList<>();
                returnVal.add(createStudyPopulationArgs());
                return returnVal;
            }

            @Override
            public Collection<ModelSettings> getModelSettings() {
                Collection<ModelSettings> returnVal = new ArrayList<>();
                returnVal.add(createAdaBoostSettings());
                returnVal.add(createDecisionTreeSettings());
                returnVal.add(createGradientBoostingMachineSettings());
                returnVal.add(createKNNSettings());
                returnVal.add(createLassoLogisticRegressionSettings());
                returnVal.add(createMLPSettings());
                returnVal.add(createNaiveBayesSettings());
                returnVal.add(createRandomForestSettings());
                return returnVal;
            }

            @Override
            public GetDbPLPDataArgs getPlpDataArgs() {
                return createGetDbPLPDataArgs();
            }

            @Override
            public RunPlpArgs getRunPlpArgs() {
                return createRunPlpArgs();
            }
        };
        //System.out.println(Utils.serializePretty(analysis, true));
        JSONAssert.assertEquals(readResource("/prediction/PatientLevelPredictionAnalysis.json"), Utils.serializePretty(analysis, true), false);
    }

    protected CreateStudyPopulationArgs createStudyPopulationArgs() {
        return new CreateStudyPopulationArgs() {
            @Override
            public Boolean getBinary() {
                return true;
            }

            @Override
            public Boolean getIncludeAllOutcomes() {
                return true;
            }

            @Override
            public Boolean getFirstExposureOnly() {
                return false;
            }

            @Override
            public Integer getWashoutPeriod() {
                return 365;
            }

            @Override
            public Boolean getRemoveSubjectsWithPriorOutcome() {
                return false;
            }

            @Override
            public Integer getPriorOutcomeLookback() {
                return 99999;
            }

            @Override
            public Boolean getRequireTimeAtRisk() {
                return true;
            }

            @Override
            public Integer getMinTimeAtRisk() {
                return 364;
            }

            @Override
            public Integer getRiskWindowStart() {
                return 1;
            }

            @Override
            public Boolean getAddExposureDaysToStart() {
                return false;
            }

            @Override
            public Integer getRiskWindowEnd() {
                return 365;
            }

            @Override
            public Boolean getAddExposureDaysToEnd() {
                return false;
            }

            @Override
            public String getAttrClass() {
                return "populationSettings";
            }
        };
    }

    protected AdaBoostSettings createAdaBoostSettings() {
        return new AdaBoostSettings() {
            @Override
            public Collection<Integer> getNEstimators() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(50);
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getLearningRate() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(1));
                return returnVal;
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }

    protected DecisionTreeSettings createDecisionTreeSettings() {
        return new DecisionTreeSettings() {
            @Override
            public Collection<Integer> getMaxDepth() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(10);
                return returnVal;
            }

            @Override
            public Collection<Integer> getMinSamplesSplit() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(2);
                return returnVal;
            }

            @Override
            public Collection<Integer> getMinSamplesLeaf() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(10);
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getMinImpurityDecrease() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(0.0000001));
                return returnVal;
            }

            @Override
            public Collection<ClassWeightEnum> getClassWeight() {
                Collection<ClassWeightEnum> returnVal = new ArrayList<>();
                returnVal.add(ClassWeightEnum.NONE);
                return returnVal;
            }

            @Override
            public Boolean getPlot() {
                return false;
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }

    protected GradientBoostingMachineSettings createGradientBoostingMachineSettings() {
        return new GradientBoostingMachineSettings() {
            @Override
            public Collection<Integer> getNTrees() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(10);
                returnVal.add(100);
                return returnVal;
            }

            @Override
            public Integer getNThread() {
                return 20;
            }

            @Override
            public Collection<Integer> getMaxDepth() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(4);
                returnVal.add(6);
                returnVal.add(17);
                return returnVal;
            }

            @Override
            public Collection<Integer> getMinRows() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(20);
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getLearnRate() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(0.01));
                returnVal.add(new BigDecimal(0.1));
                return returnVal;
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }

    protected KNNSettings createKNNSettings() {
        return new KNNSettings() {
            @Override
            public Integer getK() {
                return 1000;
            }
        };
    }

    protected LassoLogisticRegressionSettings createLassoLogisticRegressionSettings() {
        return new LassoLogisticRegressionSettings() {
            @Override
            public BigDecimal getVariance() {
                return new BigDecimal(0.01);
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }

    protected MLPSettings createMLPSettings() {
        return new MLPSettings() {
            @Override
            public Collection<Integer> getSize() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(4);
                return returnVal;
            }

            @Override
            public Collection<BigDecimal> getAlpha() {
                Collection<BigDecimal> returnVal = new ArrayList<>();
                returnVal.add(new BigDecimal(0.00001));
                return returnVal;
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }
    
    protected NaiveBayesSettings createNaiveBayesSettings() {
        return new NaiveBayesSettings() {};
    }

    protected RandomForestSettings createRandomForestSettings() {
        return new RandomForestSettings() {
            @Override
            public Collection<Integer> getMtries() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(-1);
                return returnVal;
            }

            @Override
            public Collection<Integer> getNtrees() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(500);
                return returnVal;
            }

            @Override
            public Collection<Integer> getMaxDepth() {
                Collection<Integer> returnVal = new ArrayList<>();
                returnVal.add(4);
                returnVal.add(10);
                returnVal.add(17);
                return returnVal;
            }

            @Override
            public Collection<Boolean> getVarImp() {
                Collection<Boolean> returnVal = new ArrayList<>();
                returnVal.add(true);
                return returnVal;
            }

            @Override
            public Integer getSeed() {
                return null;
            }
        };
    }

    protected GetDbPLPDataArgs createGetDbPLPDataArgs() {
        return new GetDbPLPDataArgs() {
            @Override
            public BigDecimal getMaxSampleSize() {
                return new BigDecimal(10000);
            }

            @Override
            public Integer getWashoutPeriod() {
                return 0;
            }
        };
    }

    protected RunPlpArgs createRunPlpArgs() {
        return new RunPlpArgs() {
            @Override
            public Float getMinCovariateFraction() {
                return new Float(0.001);
            }

            @Override
            public Boolean getNormalizeData() {
                return true;
            }

            @Override
            public TestSplitEnum getTestSplit() {
                return TestSplitEnum.PERSON;
            }

            @Override
            public Float getTestFraction() {
                return new Float(0.25);
            }

            @Override
            public Float getSplitSeed() {
                return new Float(0);
            }

            @Override
            public Integer getNfold() {
                return 3;
            }
        };
    }
}
