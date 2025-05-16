package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.List;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface NegativeControlOutcomeCohortExpression {

    @JsonGetter("occurrenceType")
    String getOccurrenceType();

    @JsonGetter("detectOnDescendants")
    Boolean getDetectOnDescendants();

    @JsonGetter("domains")
    List<String> getDomains();
}
