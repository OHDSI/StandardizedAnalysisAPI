package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface TargetOutcome {

    /**
     *
     * @return
     */
    @JsonGetter("targetId")
    Long getTargetId();

    /**
     *
     * @return
     */
    @JsonGetter("outcomeIds")
    Collection<Long> getOutcomeIds();
}
