package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface MatchOnPsArgs extends MatchOnPs {

    /**
     *
     * @return
     */
    @JsonGetter("stratificationColumns")
    Collection<String> getStratificationColumns();
}
