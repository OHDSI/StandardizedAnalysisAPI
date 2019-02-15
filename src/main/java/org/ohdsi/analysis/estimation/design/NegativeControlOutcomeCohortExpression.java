package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface NegativeControlOutcomeCohortExpression {

    /**
     *
     * @return
     */
    @JsonGetter("occurrenceType")
    String getOccurrenceType();

    /**
     *
     * @return
     */
    @JsonGetter("detectOnDescendants")
    Boolean getDetectOnDescendants();

    /**
     *
     * @return
     */
    @JsonGetter("domains")
    List<String> getDomains();
}
