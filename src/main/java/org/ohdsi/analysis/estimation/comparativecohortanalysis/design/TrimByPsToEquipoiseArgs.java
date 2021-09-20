package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import org.ohdsi.analysis.RLangClass;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface TrimByPsToEquipoiseArgs extends RLangClass {

    @JsonGetter("bounds")
    Collection<Float> getBounds();
}
