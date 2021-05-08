package com.tutorial.graphql.graphqltutorial.custom.exception.handler;

import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.AbortExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.UNEXPECTED;
import static com.tutorial.graphql.graphqltutorial.enumeration.ErrorType.*;
import static java.lang.String.format;

@Slf4j
@Component
public class GraphQlExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public GraphQLError handle(Throwable th) {
        var errorMessage = format(UNEXPECTED, th.getMessage());

        log.error(errorMessage, th);

        return GraphqlErrorBuilder.newError()
                .message(errorMessage)
                .errorType(UNEXPECTED_ERROR)
                .build();
    }

    @ExceptionHandler(AbortExecutionException.class)
    public GraphQLError handle(AbortExecutionException ex) {
        log.error(ex.getMessage(), ex);

        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(EXECUTION_ABORTED)
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public GraphQLError handle(ResourceNotFoundException ex) {
        log.error(ex.getMessage(), ex);

        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(RESOURCE_NOT_FOUND)
                .build();
    }
}
