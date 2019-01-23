package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface RLangClass {
    
    /**
     *
     * @return
     */
    @JsonGetter("attr_class")
    String getAttrClass();
}
