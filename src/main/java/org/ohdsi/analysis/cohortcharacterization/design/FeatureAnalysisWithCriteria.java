package org.ohdsi.analysis.cohortcharacterization.design;

import java.util.List;
import org.ohdsi.circe.cohortdefinition.ConceptSet;

public interface FeatureAnalysisWithCriteria<T, N extends Number> extends FeatureAnalysis<List<T>, N> {
	List<ConceptSet> getConceptSets();
}
