package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface GetDbPLPDataArgs {

    @JsonGetter("maxSampleSize")
    BigDecimal getMaxSampleSize();

    @JsonGetter("washoutPeriod")
    Integer getWashoutPeriod();
}
