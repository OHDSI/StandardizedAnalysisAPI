package org.ohdsi.analysis.cohortcharacterization;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.ohdsi.analysis.BaseTest;
import org.ohdsi.circe.cohortdefinition.CohortExpression;
import org.ohdsi.circe.cohortdefinition.ConceptSet;
import org.ohdsi.circe.cohortdefinition.CorelatedCriteria;
import org.ohdsi.circe.cohortdefinition.Criteria;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;
import org.ohdsi.circe.cohortdefinition.DemographicCriteria;
import org.ohdsi.circe.cohortdefinition.DrugExposure;
import org.ohdsi.circe.cohortdefinition.ObservationFilter;
import org.ohdsi.circe.cohortdefinition.Period;
import org.ohdsi.circe.cohortdefinition.PrimaryCriteria;
import org.ohdsi.circe.cohortdefinition.ResultLimit;
import org.ohdsi.circe.vocabulary.Concept;
import org.ohdsi.circe.vocabulary.ConceptSetExpression;
import org.ohdsi.analysis.Utils;
import org.ohdsi.analysis.Cohort;
import org.ohdsi.analysis.cohortcharacterization.design.CohortCharacterization;
import org.ohdsi.analysis.cohortcharacterization.design.CohortCharacterizationParam;
import org.ohdsi.analysis.cohortcharacterization.design.CriteriaFeature;
import org.ohdsi.analysis.cohortcharacterization.design.FeatureAnalysis;
import org.ohdsi.analysis.cohortcharacterization.design.FeatureAnalysisDomain;
import org.ohdsi.analysis.cohortcharacterization.design.FeatureAnalysisType;
import org.ohdsi.analysis.cohortcharacterization.design.StandardFeatureAnalysisDomain;
import org.ohdsi.analysis.cohortcharacterization.design.StandardFeatureAnalysisType;
import org.ohdsi.analysis.cohortcharacterization.result.DistributionStat;
import org.ohdsi.analysis.cohortcharacterization.result.PrevalenceStat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CohortCharacterizationTest extends BaseTest {

    @Test
    public void testCohortCharacterizationSerialization() throws IOException {

        CohortCharacterization cc = new CohortCharacterization() {

            @Override
            public List<Cohort> getCohorts() {

                Cohort cohort = new Cohort() {

                    public String getName() {

                        return "clopidogrel test";
                    }

                    public String getDescription() {

                        return "clopidogrel test";
                    }

                    public CohortExpression getExpression() {

                        CohortExpression clopidogrelExpression = new CohortExpression();

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

                return Collections.singletonList(cohort);
            }

            @Override
            public List<FeatureAnalysis> getFeatureAnalyses() {

                FeatureAnalysis presetAnalysis = new FeatureAnalysis() {

                    public FeatureAnalysisType getType() {

                        return StandardFeatureAnalysisType.PRESET;
                    }

                    public String getName() {

                        return "Demographics gender (preset)";
                    }

                    public FeatureAnalysisDomain getDomain() {

                        return StandardFeatureAnalysisDomain.DEMOGRAPHICS;
                    }

                    public String getDescr() {

                        return "Gender of the subject.";
                    }

                    public String getDesign() {

                        return "DemographicsGender";
                    }
                };

                FeatureAnalysis criteriaAnalysis = new FeatureAnalysis() {

                    public FeatureAnalysisType getType() {

                        return StandardFeatureAnalysisType.CRITERIA_SET;
                    }

                    public String getName() {

                        return "Demographics gender (via criteria)";
                    }

                    public FeatureAnalysisDomain getDomain() {

                        return StandardFeatureAnalysisDomain.DEMOGRAPHICS;
                    }

                    public String getDescr() {

                        return "Gender of the subject via criteria.";
                    }

                    public List<CriteriaFeature> getDesign() {

                        CriteriaFeature maleCriteria = new CriteriaFeature() {

                            public String getName() {

                                return "Male";
                            }

                            public CriteriaGroup getExpression() {

                                Concept maleConcept = new Concept();
                                maleConcept.conceptCode = "M";
                                maleConcept.conceptId = 8507L;
                                maleConcept.conceptName = "MALE";
                                maleConcept.domainId = "Gender";
                                maleConcept.vocabularyId = "Gender";
                                maleConcept.standardConcept = "S";
                                maleConcept.invalidReason = "V";
                                maleConcept.conceptClassId = "Gender";

                                DemographicCriteria demographicMaleCriteria = new DemographicCriteria();
                                demographicMaleCriteria.gender = new Concept[] { maleConcept };

                                CriteriaGroup maleGroup = new CriteriaGroup();
                                maleGroup.type = "ALL";
                                maleGroup.criteriaList = new CorelatedCriteria[] {};
                                maleGroup.demographicCriteriaList = new DemographicCriteria[] { demographicMaleCriteria };

                                return maleGroup;
                            }
                        };

                        CriteriaFeature femaleCriteria = new CriteriaFeature() {

                            public String getName() {

                                return "Female";
                            }

                            public CriteriaGroup getExpression() {

                                Concept femaleConcept = new Concept();
                                femaleConcept.conceptCode = "F";
                                femaleConcept.conceptId = 8532L;
                                femaleConcept.conceptName = "FEMALE";
                                femaleConcept.domainId = "Gender";
                                femaleConcept.vocabularyId = "Gender";
                                femaleConcept.standardConcept = "S";
                                femaleConcept.invalidReason = "V";
                                femaleConcept.conceptClassId = "Gender";

                                DemographicCriteria demographicFemaleCriteria = new DemographicCriteria();
                                demographicFemaleCriteria.gender = new Concept[] { femaleConcept };

                                CriteriaGroup femaleGroup = new CriteriaGroup();
                                femaleGroup.type = "ALL";
                                femaleGroup.criteriaList = new CorelatedCriteria[] {};
                                femaleGroup.demographicCriteriaList = new DemographicCriteria[] { demographicFemaleCriteria };

                                return femaleGroup;
                            }
                        };

                        return Arrays.asList(maleCriteria, femaleCriteria);
                    }
                };

                FeatureAnalysis rawSqlAnalysis = new FeatureAnalysis() {

                    public FeatureAnalysisType getType() {

                        return StandardFeatureAnalysisType.CUSTOM_FE;
                    }

                    public String getName() {

                        return "Demographics gender (raw sql)";
                    }

                    public FeatureAnalysisDomain getDomain() {

                        return StandardFeatureAnalysisDomain.DEMOGRAPHICS;
                    }

                    public String getDescr() {

                        return "Gender of the subject.";
                    }

                    public String getDesign() {

                        return "SELECT CAST(gender_concept_id AS BIGINT) * 1000 + @analysis_id AS covariate_id, COUNT(*) AS sum_value FROM @cohort_table cohort INNER JOIN @cdm_database_schema.person ON cohort.subject_id = person.person_id WHERE gender_concept_id != 0 AND cohort.cohort_definition_id = @cohort_definition_id GROUP BY gender_concept_id";
                    }
                };

                return Arrays.asList(presetAnalysis, criteriaAnalysis, rawSqlAnalysis);
            }

            public List<CohortCharacterizationParam> getParameters() {

                CohortCharacterizationParam longTermStartDays = new CohortCharacterizationParam() {

                    public String getName() {

                        return "longTermStartDays";
                    }

                    public Object getValue() {

                        return -180;
                    }
                };

                CohortCharacterizationParam shortTermStartDays = new CohortCharacterizationParam() {

                    public String getName() {

                        return "mediumTermStartDays";
                    }

                    public Object getValue() {

                        return -90;
                    }
                };

                return Arrays.asList(shortTermStartDays, longTermStartDays);
            }
        };

        Assert.assertEquals(readResource("/cohortcharacterization/CohortCharacterization.json"), Utils.serialize(cc));
    }

    @Test
    public void testPrevalenceStatSerialization() throws IOException {

        PrevalenceStat stat = new PrevalenceStat() {

            public Long getCovariateId() {

                return 18003L;
            }

            public String getCovariateName() {

                return "age group: 90-94";
            }

            public Long getConceptId() {

                return 0L;
            }

            public Long getCount() {

                return 403L;
            }

            public Double getProportion() {

                return 0.0426;
            }
        };

        Assert.assertEquals(readResource("/cohortcharacterization/PrevalenceStat.json"), Utils.serialize(stat));
    }

    @Test
    public void testDistributionStatSerialization() throws IOException {

        DistributionStat stat = new DistributionStat() {

            public Long getCovariateId() {

                return 901L;
            }

            public String getCovariateName() {

                return "Charlson index - Romano adaptation";
            }

            public Long getConceptId() {

                return 0L;
            }

            public Long getCount() {

                return 7198L;
            }

            public Double getAvg() {

                return 6.36;
            }

            public Double getStdDev() {

                return 5.52;
            }

            public Double getMin() {

                return 0.0;
            }

            public Double getP10() {

                return 0.0;
            }

            public Double getP25() {

                return 1.0;
            }

            public Double getMedian() {

                return 5.0;
            }

            public Double getP75() {

                return 10.0;
            }

            public Double getP90() {

                return 15.0;
            }

            public Double getMax() {

                return 32.0;
            }
        };

        Assert.assertEquals(readResource("/cohortcharacterization/DistributionStat.json"), Utils.serialize(stat));
    }
}
