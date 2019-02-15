package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.GRADIENT_BOOSTING_MACHINE)
public interface GradientBoostingMachineSettings extends ModelSettings, SeedSettings {

    /**
     *
     * @return
     */
    @JsonGetter("nTrees")
    Collection<Integer> getNTrees();

    /**
     *
     * @return
     */
    @JsonGetter("nThread")
    Integer getNThread();

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
    @JsonGetter("minRows")
    Collection<Integer> getMinRows();

    /**
     *
     * @return
     */
    @JsonGetter("learnRate")
    Collection<BigDecimal> getLearnRate();
}
