package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.KNN)
public interface KNNSettings extends ModelSettings {

    /**
     *
     * @return
     */
    @JsonGetter("k")
    Integer getK();
}
