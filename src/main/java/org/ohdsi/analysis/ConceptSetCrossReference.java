package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface ConceptSetCrossReference {

    /**
     * 
     * @return The concept set ID
     */
    @JsonGetter("conceptSetId")
  Integer getConceptSetId();

    /**
     *
     * @return The target name
     */
    @JsonGetter("targetName")
  String getTargetName();

    /**
     *
     * @return The target index
     */
    @JsonGetter("targetIndex")
  Integer getTargetIndex();

    /**
     *
     * @return The property name
     */
    @JsonGetter("propertyName")
  String getPropertyName();
}
