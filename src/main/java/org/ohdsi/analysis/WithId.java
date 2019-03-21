package org.ohdsi.analysis;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface WithId<T extends Number>  {

    @JsonGetter("id")
    T getId();
}
