package org.ohdsi.analysis.cohortcharacterization.design;

public final class EventCountAggregate implements FeatureAnalysisAggregate {

    private static final EventCountAggregate INSTANCE = new EventCountAggregate();

    public static FeatureAnalysisAggregate getInstance() {

        return INSTANCE;
    }

    @Override
    public String getName() {

        return "Event count";
    }

    @Override
    public FeatureAnalysisDomain getDomain() {

        return null;
    }

    @Override
    public AggregateFunction getFunction() {

        return AggregateFunction.COUNT;
    }

    @Override
    public String getExpression() {

        return "*";
    }

    @Override
    public boolean hasQuery() {

        return false;
    }

    @Override
    public String getQuery() {

        return null;
    }
}
