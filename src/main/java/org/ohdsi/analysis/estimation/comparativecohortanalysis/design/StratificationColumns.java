package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface StratificationColumns {

    @JsonGetter("stratificationColumns")
    Collection<String> getStratificationColumns();
}
