package org.ohdsi.analysis.versioning;

public class IncompatibleVersionsException extends RuntimeException {

    public IncompatibleVersionsException(String message) {

        super(message);
    }
}
