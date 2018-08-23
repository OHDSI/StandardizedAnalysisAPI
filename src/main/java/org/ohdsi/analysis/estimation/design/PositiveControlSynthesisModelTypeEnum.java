/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

  /**
   * Can be either \&quot;poisson\&quot; or \&quot;survival\&quot; 
   */
public enum PositiveControlSynthesisModelTypeEnum {
    POISSON("poisson"),

    SURVIVAL("survival");

    private String value;

    PositiveControlSynthesisModelTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositiveControlSynthesisModelTypeEnum fromValue(String text) {
      for (PositiveControlSynthesisModelTypeEnum b : PositiveControlSynthesisModelTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
}