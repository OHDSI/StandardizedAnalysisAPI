package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface TrimByPsToEquipoiseArgs extends RLangClass {

    /**
     *
     * @return
     */
    @JsonGetter("bounds")
    Collection<Float> getBounds();
}
