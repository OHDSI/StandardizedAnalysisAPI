package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TestSplitEnum {
    TIME("time"),
    
    PERSON("person");

    private String value;

    TestSplitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TestSplitEnum fromValue(String text) {
      for (TestSplitEnum b : TestSplitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }    
}
