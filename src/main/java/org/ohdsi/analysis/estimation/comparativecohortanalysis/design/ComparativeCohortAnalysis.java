package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Collection;
import org.ohdsi.analysis.estimation.design.EstimationAnalysisConst;
import org.ohdsi.analysis.estimation.design.Settings;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(EstimationAnalysisConst.COMPARATIVE_COHORT_ANALYSIS)
public interface ComparativeCohortAnalysis extends Settings {

    @JsonGetter("targetComparatorOutcomes")
    Collection<? extends TargetComparatorOutcomes> getTargetComparatorOutcomes();

    @JsonGetter("cohortMethodAnalysisList")
    Collection<? extends CohortMethodAnalysis> getCohortMethodAnalysisList();
}
