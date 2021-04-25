package com.tutorial.graphql.graphqltutorial.custom.context;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Component
@RequiredArgsConstructor
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {

    private final DataLoaderRegistry dataLoaderRegistry;

    @Override
    public GraphQLContext build(HttpServletRequest request, HttpServletResponse response) {
        return DefaultGraphQLServletContext.createServletContext(dataLoaderRegistry, null)
                .with(request)
                .with(response)
                .build();
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest request) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext(dataLoaderRegistry, null)
                .with(session)
                .with(request)
                .build();
    }

    @Override
    public GraphQLContext build() {
        return DefaultGraphQLServletContext.createServletContext(dataLoaderRegistry, null)
                .build();
    }
}
