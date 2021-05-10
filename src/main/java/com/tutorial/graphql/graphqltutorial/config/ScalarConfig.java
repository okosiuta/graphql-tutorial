package com.tutorial.graphql.graphqltutorial.config;

import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.COERCING_SERIALIZATION_ERROR;
import static com.tutorial.graphql.graphqltutorial.enumeration.Scalar.LOCAL_DATE_TIME;
import static graphql.scalars.ExtendedScalars.Date;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Configuration
public class ScalarConfig {

    @Bean
    public GraphQLScalarType localDateScalar() {
        return Date;
    }

    @Bean
    public GraphQLScalarType localDateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name(LOCAL_DATE_TIME.getName())
                .description(LOCAL_DATE_TIME.getDescription())
                .coercing(localDateTimeStringCoercing())
                .build();
    }

    private Coercing<LocalDateTime, String> localDateTimeStringCoercing() {
        return new Coercing<>() {

            @Override
            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                if (dataFetcherResult instanceof LocalDateTime localDateTime) {
                    return (localDateTime).format(ISO_DATE_TIME);
                } else {
                    throw new CoercingSerializeException(COERCING_SERIALIZATION_ERROR);
                }
            }

            @Override
            public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
                //skipped for simplicity
                return null;
            }

            @Override
            public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                //skipped for simplicity
                return null;
            }
        };
    }
}
