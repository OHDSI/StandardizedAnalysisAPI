package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface GetDbPLPDataArgs {

    /**
     *
     * @return
     */
    @JsonGetter("maxSampleSize")
    BigDecimal getMaxSampleSize();

    /**
     *
     * @return
     */
    @JsonGetter("washoutPeriod")
    Integer getWashoutPeriod();
}
