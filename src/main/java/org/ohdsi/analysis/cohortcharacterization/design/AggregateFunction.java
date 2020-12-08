package org.ohdsi.analysis.cohortcharacterization.design;

public enum AggregateFunction {
    COUNT("count"),
    AVG("avg"),
    MIN("min"),
    MAX("max"),
    SUM("sum");

    private String name;

    AggregateFunction(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
