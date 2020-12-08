package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "criteriaGroup" })
public interface BaseCriteriaFeature<T> {

	@JsonGetter("name")
	String getName();

	@JsonGetter("expression")
	T getExpression();

	@JsonGetter("aggregate")
	default FeatureAnalysisAggregate getAggregate() {

		return EventCountAggregate.getInstance();
	}
}
