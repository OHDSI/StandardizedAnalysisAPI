package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface NegativeControl {

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
    @JsonGetter("comparatorId")
    Long getComparatorId();

    /**
     *
     * @return
     */
    @JsonGetter("outcomeId")
    Long getOutcomeId();

    /**
     *
     * @return
     */
    @JsonGetter("outcomeName")
    String getOutcomeName();

    /**
     *
     * @return
     */
    @JsonGetter("type")
    NegativeControlTypeEnum getType();
}
