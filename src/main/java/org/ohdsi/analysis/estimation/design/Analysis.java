package org.ohdsi.analysis.estimation.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface Analysis extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("analysisId")
    Integer getAnalysisId();

    /**
     *
     * @return
     */
    @JsonGetter("description")
    String getDescription();
}
