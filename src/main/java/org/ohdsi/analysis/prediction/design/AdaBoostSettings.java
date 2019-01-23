package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.ADA_BOOST)
public interface AdaBoostSettings extends ModelSettings, SeedSettings {

    /**
     *
     * @return
     */
    @JsonGetter("nEstimators")
    Collection<Integer> getNEstimators();

    /**
     *
     * @return
     */
    @JsonGetter("learningRate")
    Collection<BigDecimal> getLearningRate();
}
