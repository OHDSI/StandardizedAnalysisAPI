package org.ohdsi.analysis.cohortcharacterization.design;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.ohdsi.analysis.WithId;

@JsonPropertyOrder({ "id", "type", "name", "domain", "statType", "descr", "design" })
public interface FeatureAnalysis<T, N extends Number> extends WithId<N> {

    @JsonGetter("type")
    FeatureAnalysisType getType();

    @JsonGetter("name")
    String getName();

    @JsonGetter("domain")
    FeatureAnalysisDomain getDomain();

    @JsonGetter("descr")
    String getDescr();

    @JsonGetter("design")
    T getDesign();

    @JsonGetter("statType")
    default CcResultType getStatType() {
        return CcResultType.PREVALENCE;
    }
}
