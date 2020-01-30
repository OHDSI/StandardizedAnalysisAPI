package org.ohdsi.analysis.cohortcharacterization.design;

public interface FeatureAnalysisAggregate {
    String getName();
    FeatureAnalysisDomain getDomain();
    AggregateFunction getFunction();
    String getExpression();
    boolean hasSourceTable();
    String getSourceTable();
}
