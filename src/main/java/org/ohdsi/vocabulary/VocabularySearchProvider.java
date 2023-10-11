package org.ohdsi.vocabulary;

import java.util.Collection;

public interface VocabularySearchProvider {
    boolean supports(String vocabularyVersionKey);
    int getPriority();
    Collection<Concept> executeSearch(VocabularySearchProviderConfig config, String query, String rows) throws Exception;
}
