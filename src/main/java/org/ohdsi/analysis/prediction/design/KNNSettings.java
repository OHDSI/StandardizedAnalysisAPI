package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.KNN)
public interface KNNSettings extends ModelSettings {

    @JsonGetter("k")
    Integer getK();
}
