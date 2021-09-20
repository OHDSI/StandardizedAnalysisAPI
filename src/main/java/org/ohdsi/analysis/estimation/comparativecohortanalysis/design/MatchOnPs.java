package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface MatchOnPs extends RLangClass {

    @JsonGetter("caliper")
    Float getCaliper();

    @JsonGetter("caliperScale")
    CaliperScaleEnum getCaliperScale();

    @JsonGetter("maxRatio")
    Integer getMaxRatio();
}
