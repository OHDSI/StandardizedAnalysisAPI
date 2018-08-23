package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SkeletonTypeEnum {
    PATIENTLEVELPREDICTIONSTUDY("PatientLevelPredictionStudy");

    private String value;

    SkeletonTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SkeletonTypeEnum fromValue(String text) {
      for (SkeletonTypeEnum b : SkeletonTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }    
}
