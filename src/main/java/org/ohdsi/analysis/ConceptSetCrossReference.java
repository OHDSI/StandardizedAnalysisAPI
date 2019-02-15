package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface ConceptSetCrossReference {

    /**
     *
     * @return
     */
    @JsonGetter("conceptSetId")
  Integer getConceptSetId();

    /**
     *
     * @return
     */
    @JsonGetter("targetName")
  String getTargetName();

    /**
     *
     * @return
     */
    @JsonGetter("targetIndex")
  Integer getTargetIndex();

    /**
     *
     * @return
     */
    @JsonGetter("propertyName")
  String getPropertyName();
}
