package com.tutorial.graphql.graphqltutorial.constant;

public class ErrorMessage {

    public static final String UNEXPECTED = "Unexpected error! %s";
    public static final String RESOURCE_NOT_FOUND = "Can't find %s resource by id: %s";

    private ErrorMessage() {
        throw new UnsupportedOperationException();
    }
}
