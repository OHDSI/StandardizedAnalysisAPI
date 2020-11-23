package org.ohdsi.analysis;

public enum TableJoin {
    INNER_JOIN("inner join"),
    LEFT_JOIN("left join"),
    RIGHT_JOIN("right join"),
    CROSS_JOIN("cross join");

    private String term;

    TableJoin(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }
}
