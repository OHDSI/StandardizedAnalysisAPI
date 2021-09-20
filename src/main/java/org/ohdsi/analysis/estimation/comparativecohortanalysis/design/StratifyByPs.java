package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface StratifyByPs extends RLangClass {

    @JsonGetter("numberOfStrata")
    Integer getNumberOfStrata();

    @JsonGetter("baseSelection")
    BaseSelectionEnum getBaseSelection();
}
