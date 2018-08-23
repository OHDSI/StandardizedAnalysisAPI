package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface ConceptSetCrossReference {
  @JsonGetter("conceptSetId")
  Integer getConceptSetId();

  @JsonGetter("targetName")
  String getTargetName();

  @JsonGetter("targetIndex")
  Integer getTargetIndex();

  @JsonGetter("propertyName")
  String getPropertyName();
}
