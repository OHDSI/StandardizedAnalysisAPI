package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface TrimByPsArgs extends RLangClass {

    @JsonGetter("trimFraction")
    Float getTrimFraction();
}
