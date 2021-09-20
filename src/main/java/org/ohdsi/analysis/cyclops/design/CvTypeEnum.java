package org.ohdsi.analysis.cyclops.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * name of cross validation search. Option \&quot;auto\&quot; selects an
 * auto-search following BBR. Option \&quot;grid\&quot; selects a grid-search
 * cross validation
 */
public enum CvTypeEnum {

    AUTO("auto"),
    GRID("grid");

    private final String value;

    CvTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static CvTypeEnum fromValue(String text) {
        for (CvTypeEnum b : CvTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
