package org.ohdsi.analysis.cohortcharacterization.design;

import org.ohdsi.analysis.TableJoin;
import org.ohdsi.circe.cohortdefinition.builders.CriteriaColumn;

import java.util.Collections;
import java.util.List;

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
    public List<CriteriaColumn> getAdditionalColumns() {

        return Collections.emptyList();
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
    public String getJoinTable() {
        return null;
    }

    @Override
    public String getJoinCondition() {
        return null;
    }

    @Override
    public TableJoin getJoinType() {
        return null;
    }

    @Override
    public Integer getId() {

        return null;
    }

    @Override
    public boolean isMissingMeansZero() {
        return true;
    }
}
