package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.WithId;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;

public interface CohortCharacterizationStrata extends WithId<Long> {
	@JsonGetter("name")
	String getName();

	@JsonGetter("criteria")
	CriteriaGroup getCriteria();
}
