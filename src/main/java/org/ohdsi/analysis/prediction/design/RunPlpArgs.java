package org.ohdsi.analysis.prediction.design;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 * @author Anthony Sena <https://github.com/anthonysena>
 */
public interface RunPlpArgs {

    /**
     *
     * @return
     */
    @JsonGetter("minCovariateFraction")
    Float getMinCovariateFraction();

    /**
     *
     * @return
     */
    @JsonGetter("normalizeData")
    Boolean getNormalizeData();

    /**
     *
     * @return
     */
    @JsonGetter("testSplit")
    TestSplitEnum getTestSplit();

    /**
     *
     * @return
     */
    @JsonGetter("testFraction")
    Float getTestFraction();

    /**
     *
     * @return
     */
    @JsonGetter("splitSeed")
    Float getSplitSeed();

    /**
     *
     * @return
     */
    @JsonGetter("nfold")
    Integer getNfold();
}
