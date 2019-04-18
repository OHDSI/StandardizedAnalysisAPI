package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.estimation.design.TargetOutcome;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface TargetComparatorOutcomes extends TargetOutcome {

    /**
     *
     * @return
     */
    @JsonGetter("comparatorId")
    Long getComparatorId();

    /**
     *
     * @return
     */
    @JsonGetter("excludedCovariateConceptIds")
    Collection<Long> getExcludedCovariateConceptIds();

    /**
     *
     * @return
     */
    @JsonGetter("includedCovariateConceptIds")
    Collection<Long> getIncludedCovariateConceptIds();
}
