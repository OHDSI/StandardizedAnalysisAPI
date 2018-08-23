package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EstimationTypeEnum {
  COMPARATIVE_COHORT_ANALYSIS("ComparativeCohortAnalysis");

  private final String value;

  EstimationTypeEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EstimationTypeEnum fromValue(String text) {
    for (EstimationTypeEnum b : EstimationTypeEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
