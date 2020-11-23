package org.ohdsi.analysis.cohortcharacterization.design;

public enum StandardFeatureAnalysisDomain implements FeatureAnalysisDomain {
    CONDITION("Condition"),
    CONDITION_ERA("Condition Era"),
    DEMOGRAPHICS("Demographics"),
    DEVICE("Device"),
    DRUG("Drug"),
    DRUG_ERA("Drug Era"),
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
