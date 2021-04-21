package com.tutorial.graphql.graphqltutorial.graphql.scalar;

import graphql.schema.*;
import org.springframework.stereotype.Component;

@Component
public class VoidScalarType extends GraphQLScalarType {

    public VoidScalarType() {
        super("Void", "", new Coercing<Void, String>() {

            @Override
            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                return null;
            }

            @Override
            public Void parseValue(Object input) throws CoercingParseValueException {
                return null;
            }

            @Override
            public Void parseLiteral(Object input) throws CoercingParseLiteralException {
                return null;
            }
        });
    }
}