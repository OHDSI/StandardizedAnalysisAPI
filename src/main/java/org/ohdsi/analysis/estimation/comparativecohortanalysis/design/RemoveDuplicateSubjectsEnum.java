package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public enum RemoveDuplicateSubjectsEnum {

    /**
     *
     */
    KEEP_ALL("keep all"),
    /**
     *
     */
    KEEP_FIRST("keep first"),
    /**
     *
     */
    REMOVE_ALL("remove all");

    private final String value;

    RemoveDuplicateSubjectsEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static RemoveDuplicateSubjectsEnum fromValue(String text) {
        for (RemoveDuplicateSubjectsEnum b : RemoveDuplicateSubjectsEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
