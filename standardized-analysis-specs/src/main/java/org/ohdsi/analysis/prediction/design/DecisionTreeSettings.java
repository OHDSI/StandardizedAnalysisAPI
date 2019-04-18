package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
@JsonTypeName(ModelSettingsConst.DECISION_TREE)
public interface DecisionTreeSettings extends ModelSettings, SeedSettings {

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
    @JsonGetter("minSamplesSplit")
    Collection<Integer> getMinSamplesSplit();

    /**
     *
     * @return
     */
    @JsonGetter("minSamplesLeaf")
    Collection<Integer> getMinSamplesLeaf();

    /**
     *
     * @return
     */
    @JsonGetter("minImpurityDecrease")
    Collection<BigDecimal> getMinImpurityDecrease();

    /**
     *
     * @return
     */
    @JsonGetter("classWeight")
    Collection<ClassWeightEnum> getClassWeight();

    /**
     *
     * @return
     */
    @JsonGetter("plot")
    Boolean getPlot();
}
