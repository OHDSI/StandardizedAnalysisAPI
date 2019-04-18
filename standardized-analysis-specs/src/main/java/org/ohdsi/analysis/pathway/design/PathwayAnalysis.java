package org.ohdsi.analysis.pathway.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.Cohort;

import java.util.Collection;

public interface PathwayAnalysis {

    @JsonGetter("name")
    String getName();

    @JsonGetter("targetCohorts")
    Collection<? extends Cohort> getTargetCohorts();

    @JsonGetter("eventCohorts")
    Collection<? extends Cohort> getEventCohorts();

    @JsonGetter("combinationWindow")
    Integer getCombinationWindow();

    @JsonGetter("minCellCount")
    Integer getMinCellCount();

    @JsonGetter("maxDepth")
    Integer getMaxDepth();

    @JsonGetter("allowRepeats")
    boolean isAllowRepeats();
}
