package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.MLP)
public interface MLPSettings extends ModelSettings, SeedSettings {

    @JsonGetter("size")
    Collection<Integer> getSize();

    @JsonGetter("alpha")
    Collection<BigDecimal> getAlpha();
}
