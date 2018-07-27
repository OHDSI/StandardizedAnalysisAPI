package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

public enum StandardFeatureAnalysisType implements FeatureAnalysisType {
    PRESET("Preset"),
    CRITERIA_SET("Criteria set"),
    CUSTOM_FE("Custom FE analysis");

    private String name;

    StandardFeatureAnalysisType(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
