package com.tutorial.graphql.graphqltutorial.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Scalar {

    LOCAL_DATE_TIME("LocalDateTime", "LocalDateTime");

    private final String name;
    private final String description;
}
