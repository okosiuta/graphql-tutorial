package com.tutorial.graphql.graphqltutorial.enumeration;

import graphql.ErrorClassification;

public enum ErrorType implements ErrorClassification {

    UNEXPECTED_ERROR,
    RESOURCE_NOT_FOUND,
    EXECUTION_ABORTED
}
