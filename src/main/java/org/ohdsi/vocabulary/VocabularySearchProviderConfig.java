package org.ohdsi.vocabulary;

public class VocabularySearchProviderConfig {
    private String sourceKey;
    private String versionKey;
    
    public VocabularySearchProviderConfig(String sourceKey, String versionKey) {
        this.sourceKey = sourceKey;
        this.versionKey = versionKey;
    }
    
    public String getVersionKey() {
        return versionKey;
    }
    
    public String getSourceKey() {
        return sourceKey;
    }
}
