package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.GRADIENT_BOOSTING_MACHINE)
public interface GradientBoostingMachineSettings extends ModelSettings, SeedSettings {

    @JsonGetter("ntrees")
    Collection<Integer> getNTrees();

    @JsonGetter("nthread")
    Integer getNThread();

    @JsonGetter("maxDepth")
    Collection<Integer> getMaxDepth();

    @JsonGetter("minRows")
    Collection<Integer> getMinRows();

    @JsonGetter("learnRate")
    Collection<BigDecimal> getLearnRate();
}
