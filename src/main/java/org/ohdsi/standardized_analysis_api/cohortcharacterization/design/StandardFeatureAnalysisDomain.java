package org.ohdsi.standardized_analysis_api.cohortcharacterization.design;

public enum StandardFeatureAnalysisDomain implements FeatureAnalysisDomain {
    CONDITION("Condition"),
    DEMOGRAPHICS("Demographics"),
    DEVICE("Device"),
    DRUG("Drug"),
    MEASUREMENT("Measurement"),
    OBSERVATION("Observation"),
    PROCEDURE("Procedure"),
    VISIT("Visit");

    private String name;

    StandardFeatureAnalysisDomain(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
