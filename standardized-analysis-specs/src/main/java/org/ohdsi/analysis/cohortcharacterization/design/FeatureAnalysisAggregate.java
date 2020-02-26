package org.ohdsi.analysis.cohortcharacterization.design;

import org.ohdsi.analysis.WithId;

public interface FeatureAnalysisAggregate extends WithId<Integer> {
    String getName();
    FeatureAnalysisDomain getDomain();
    AggregateFunction getFunction();
    String getExpression();
    boolean hasQuery();
    String getQuery();
}
