package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Collection;
import org.ohdsi.analysis.estimation.design.EstimationAnalysisConst;
import org.ohdsi.analysis.estimation.design.Settings;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(EstimationAnalysisConst.COMPARATIVE_COHORT_ANALYSIS)
public interface ComparativeCohortAnalysis extends Settings {

    /**
     *
     * @return
     */
    @JsonGetter("targetComparatorOutcomes")
    Collection<? extends TargetComparatorOutcomes> getTargetComparatorOutcomes();

    /**
     *
     * @return
     */
    @JsonGetter("cohortMethodAnalysisList")
    Collection<? extends CohortMethodAnalysis> getCohortMethodAnalysisList();
}
