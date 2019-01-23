package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface SeedSettings {

    /**
     *
     * @return
     */
    @JsonGetter("seed")
    Integer getSeed();
}
