package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.estimation.design.TargetOutcome;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface TargetComparatorOutcomes extends TargetOutcome {

    @JsonGetter("comparatorId")
    Long getComparatorId();

    @JsonGetter("excludedCovariateConceptIds")
    Collection<Long> getExcludedCovariateConceptIds();

    @JsonGetter("includedCovariateConceptIds")
    Collection<Long> getIncludedCovariateConceptIds();
}
