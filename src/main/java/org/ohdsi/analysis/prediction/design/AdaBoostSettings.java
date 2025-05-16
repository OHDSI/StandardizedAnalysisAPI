package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.ADA_BOOST)
public interface AdaBoostSettings extends ModelSettings, SeedSettings {

    @JsonGetter("nEstimators")
    Collection<Integer> getNEstimators();

    @JsonGetter("learningRate")
    Collection<BigDecimal> getLearningRate();
}
