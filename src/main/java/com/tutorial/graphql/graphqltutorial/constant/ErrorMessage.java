package com.tutorial.graphql.graphqltutorial.constant;

public class ErrorMessage {

    public static final String UNEXPECTED = "Unexpected error! %s";
    public static final String RESOURCE_NOT_FOUND = "Can't find %s resource by id: %s";
    public static final String COERCING_SERIALIZATION_ERROR = "Coercing serialization failed";

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }
}
