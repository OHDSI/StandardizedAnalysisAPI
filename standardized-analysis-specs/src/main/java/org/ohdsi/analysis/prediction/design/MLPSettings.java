package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.MLP)
public interface MLPSettings extends ModelSettings, SeedSettings {

    /**
     *
     * @return
     */
    @JsonGetter("size")
    Collection<Integer> getSize();

    /**
     *
     * @return
     */
    @JsonGetter("alpha")
    Collection<BigDecimal> getAlpha();
}
