package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface TargetOutcome {

    @JsonGetter("targetId")
    Long getTargetId();

    @JsonGetter("outcomeIds")
    Collection<Long> getOutcomeIds();
}
