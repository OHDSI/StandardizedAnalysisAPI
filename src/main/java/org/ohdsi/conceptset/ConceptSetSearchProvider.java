package org.ohdsi.conceptset;

import java.util.Collection;
import java.util.Set;

public interface ConceptSetSearchProvider {
    Set<Integer> executeSearch(String query, String[] domainIds);

    boolean isSearchAvailable();

    void clearConceptSetIndex();
	
    void reindexConceptSet(final Integer conceptSetId, final Collection<ConceptSetSearchDocument> documents);

    void deleteConceptSetIndex(final Integer id);
    
    int getPriority();
}
