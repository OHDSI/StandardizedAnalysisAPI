package org.ohdsi.analysis.estimation.comparativecohortanalysis.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface CovariateArgs {

    @JsonGetter("covariateIds")
    Collection<Integer> getCovariateIds();
}
