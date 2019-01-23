package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface MatchOnPs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("caliper")
    Float getCaliper();

    /**
     *
     * @return
     */
    @JsonGetter("caliperScale")
    CaliperScaleEnum getCaliperScale();

    /**
     *
     * @return
     */
    @JsonGetter("maxRatio")
    Integer getMaxRatio();
}
