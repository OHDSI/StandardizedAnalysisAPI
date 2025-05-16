package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface Analysis extends RLangClass {

    @JsonGetter("analysisId")
    Integer getAnalysisId();

    @JsonGetter("description")
    String getDescription();
}
