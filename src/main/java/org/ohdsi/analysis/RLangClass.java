package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface RLangClass {
    
    /**
     *
     * @return The attribute class as defined in the corresponding R class
     */
    @JsonGetter("attr_class")
    String getAttrClass();
}
