package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
@JsonTypeName(ModelSettingsConst.DECISION_TREE)
public interface DecisionTreeSettings extends ModelSettings, SeedSettings {

    @JsonGetter("maxDepth")
    Collection<Integer> getMaxDepth();

    @JsonGetter("minSamplesSplit")
    Collection<Integer> getMinSamplesSplit();

    @JsonGetter("minSamplesLeaf")
    Collection<Integer> getMinSamplesLeaf();

    @JsonGetter("minImpurityDecrease")
    Collection<BigDecimal> getMinImpurityDecrease();

    @JsonGetter("classWeight")
    Collection<ClassWeightEnum> getClassWeight();

    @JsonGetter("plot")
    Boolean getPlot();
}
