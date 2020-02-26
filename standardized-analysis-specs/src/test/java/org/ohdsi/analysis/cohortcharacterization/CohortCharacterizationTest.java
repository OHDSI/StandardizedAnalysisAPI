package org.ohdsi.analysis.cohortcharacterization;

import java.util.Collection;
import java.util.Collections;
import org.json.JSONException;
import org.junit.Test;
import org.ohdsi.analysis.BaseTest;
import org.ohdsi.analysis.cohortcharacterization.design.CcResultType;
import org.ohdsi.analysis.cohortcharacterization.design.CohortCharacterizationStrata;
import org.ohdsi.circe.cohortdefinition.ConceptSet;
import org.ohdsi.circe.cohortdefinition.CorelatedCriteria;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;
import org.ohdsi.circe.cohortdefinition.DemographicCriteria;
import org.ohdsi.circe.vocabulary.Concept;
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
import org.skyscreamer.jsonassert.JSONAssert;

public class CohortCharacterizationTest extends BaseTest {

    @Test
    public void testCohortCharacterizationSerialization() throws IOException, JSONException {

        CohortCharacterization cc = new CohortCharacterization() {

            @Override
            public List<ConceptSet> getStrataConceptSets() {

                return Collections.emptyList();
            }

            @Override
            public String getName() {

                return "CC test";
            }

            @Override
            public List<Cohort> getCohorts() {
                return Collections.singletonList(createCohort());
            }

            @Override
            public List<FeatureAnalysis> getFeatureAnalyses() {

                FeatureAnalysis presetAnalysis = new FeatureAnalysis() {

                    @Override
                    public Long getId() {

                        return 1L;
                    }

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

                    @Override
                    public CcResultType getStatType() {

                        return CcResultType.PREVALENCE;
                    }
                };

                FeatureAnalysis criteriaAnalysis = new FeatureAnalysis() {

                    @Override
                    public Long getId() {

                        return 1L;
                    }

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

                    @Override
                    public CcResultType getStatType() {

                        return CcResultType.PREVALENCE;
                    }
                };

                FeatureAnalysis rawSqlAnalysis = new FeatureAnalysis() {

                    @Override
                    public Long getId() {

                        return 1L;
                    }

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

                    @Override
                    public CcResultType getStatType() {

                        return CcResultType.PREVALENCE;
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

            @Override
            public Collection<? extends CohortCharacterizationStrata> getStratas() {

                return Collections.emptyList();
            }

            @Override
            public Boolean getStrataOnly() {

                return false;
            }
        };

        JSONAssert.assertEquals(readResource("/cohortcharacterization/CohortCharacterization.json"), Utils.serializePretty(cc), false);
    }

    @Test
    public void testPrevalenceStatSerialization() throws IOException, JSONException {

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

        JSONAssert.assertEquals(readResource("/cohortcharacterization/PrevalenceStat.json"), Utils.serializePretty(stat), false);
    }

    @Test
    public void testDistributionStatSerialization() throws IOException, JSONException {

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

            @Override
            public Integer getAggregateId() {

                return 0;
            }

            @Override
            public String getAggregateName() {

                return "";
            }
        };

        JSONAssert.assertEquals(readResource("/cohortcharacterization/DistributionStat.json"), Utils.serializePretty(stat), false);
    }
}
