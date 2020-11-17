package org.ohdsi.analysis.cohortcharacterization.design;

import org.ohdsi.analysis.TableJoin;
import org.ohdsi.analysis.WithId;
import org.ohdsi.circe.cohortdefinition.builders.CriteriaColumn;

import java.util.List;

public interface FeatureAnalysisAggregate extends WithId<Integer> {
    String getName();
    FeatureAnalysisDomain getDomain();
    AggregateFunction getFunction();
    List<CriteriaColumn> getAdditionalColumns();
    String getExpression();
    boolean hasQuery();
    String getJoinTable();
    String getJoinCondition();
    TableJoin getJoinType();
    boolean isMissingMeansZero();
}
