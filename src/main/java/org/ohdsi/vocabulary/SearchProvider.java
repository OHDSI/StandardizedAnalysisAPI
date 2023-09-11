package org.ohdsi.vocabulary;

import java.util.Collection;

public interface SearchProvider {
    boolean supports(String vocabularyVersionKey);
    int getPriority();
    Collection<Concept> executeSearch(SearchProviderConfig config, String query, String rows) throws Exception;
}
