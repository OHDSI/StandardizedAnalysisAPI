package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.circe.cohortdefinition.CriteriaGroup;

public interface CohortCharacterizationStrata {
	@JsonGetter("name")
	String getName();

	@JsonGetter("criteria")
	CriteriaGroup getCriteria();
}
