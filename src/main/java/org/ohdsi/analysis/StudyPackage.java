package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

public interface StudyPackage {
    /**
     * The name of the R Package for execution
     *
     * @return packageName
     *
     */
    @JsonGetter(value = "packageName")
    @JsonInclude
    String getPackageName();
}
