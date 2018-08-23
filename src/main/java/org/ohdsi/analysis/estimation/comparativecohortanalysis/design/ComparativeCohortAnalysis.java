package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.estimation.design.Analysis;

public interface ComparativeCohortAnalysis {
    @JsonGetter("targetComparatorOutcomes")
    Collection<? extends TargetComparatorOutcomes> getTargetComparatorOutcomes();
    
    @JsonGetter("cohortMethodAnalysisList")
    Collection<? extends CohortMethodAnalysis> getCohortMethodAnalysisList();    
}
