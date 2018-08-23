/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * level of Cyclops screen output (\&quot;silent\&quot;, \&quot;quiet\&quot;, \&quot;noisy\&quot;) 
 */
public enum NoiseLevelEnum {
  SILENT("silent"),

  QUIET("quiet"),

  NOISY("noisy");

  private String value;

  NoiseLevelEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NoiseLevelEnum fromValue(String text) {
    for (NoiseLevelEnum b : NoiseLevelEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}