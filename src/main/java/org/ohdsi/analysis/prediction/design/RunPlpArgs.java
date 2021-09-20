package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Anthony Sena sena@ohdsi.org
 */
public interface RunPlpArgs {

    @JsonGetter("minCovariateFraction")
    Float getMinCovariateFraction();

    @JsonGetter("normalizeData")
    Boolean getNormalizeData();

    @JsonGetter("testSplit")
    TestSplitEnum getTestSplit();

    @JsonGetter("testFraction")
    Float getTestFraction();

    @JsonGetter("splitSeed")
    Float getSplitSeed();

    @JsonGetter("nfold")
    Integer getNfold();
}
