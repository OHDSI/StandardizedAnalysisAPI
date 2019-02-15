package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.RANDOM_FOREST)
public interface RandomForestSettings extends ModelSettings, SeedSettings {

    /**
     *
     * @return
     */
    @JsonGetter("mtries")
    Collection<Integer> getMtries();

    /**
     *
     * @return
     */
    @JsonGetter("ntrees")
    Collection<Integer> getNtrees();

    /**
     *
     * @return
     */
    @JsonGetter("maxDepth")
    Collection<Integer> getMaxDepth();

    /**
     *
     * @return
     */
    @JsonGetter("varImp")
    Collection<Boolean> getVarImp();
}
