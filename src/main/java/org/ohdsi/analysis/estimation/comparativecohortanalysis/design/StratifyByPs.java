package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface StratifyByPs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("numberOfStrata")
    Integer getNumberOfStrata();

    /**
     *
     * @return
     */
    @JsonGetter("baseSelection")
    BaseSelectionEnum getBaseSelection();
}
