package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.RANDOM_FOREST)
public interface RandomForestSettings extends ModelSettings, SeedSettings {

    @JsonGetter("mtries")
    Collection<Integer> getMtries();

    @JsonGetter("ntrees")
    Collection<Integer> getNtrees();

    @JsonGetter("maxDepth")
    Collection<Integer> getMaxDepth();

    @JsonGetter("varImp")
    Collection<Boolean> getVarImp();
}
