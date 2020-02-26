package org.ohdsi.analysis.cohortcharacterization.result;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "covariateId", "covariateName", "aggregateId", "aggregateName", "conceptId", "count", "avg", "stdDev", "min", "p10", "p25", "median", "p75", "p90", "max" })
public interface DistributionStat extends BaseStat {

    @JsonGetter("avg")
    Double getAvg();

    @JsonGetter("stdDev")
    Double getStdDev();

    @JsonGetter("min")
    Double getMin();

    @JsonGetter("p10")
    Double getP10();

    @JsonGetter("p25")
    Double getP25();

    @JsonGetter("median")
    Double getMedian();

    @JsonGetter("p75")
    Double getP75();

    @JsonGetter("p90")
    Double getP90();

    @JsonGetter("max")
    Double getMax();

    @JsonGetter("aggregateId")
    Integer getAggregateId();

    @JsonGetter("aggregateName")
    String getAggregateName();
}
