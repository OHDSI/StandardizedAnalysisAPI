package org.ohdsi.standardized_analysis_api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.circe.cohortdefinition.CohortExpression;

public interface Cohort extends CohortMetadata {
    @JsonGetter("expression")
    CohortExpression getCohortExpression();
}
