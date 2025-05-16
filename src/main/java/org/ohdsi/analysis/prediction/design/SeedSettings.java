package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface SeedSettings {

    @JsonGetter("seed")
    Integer getSeed();
}
