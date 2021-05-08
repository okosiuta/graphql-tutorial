package com.tutorial.graphql.graphqltutorial.custom.pagination;

import graphql.relay.DefaultConnection;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class ExtendedConnection<T> extends DefaultConnection<T> {

    private final long totalCount;

    public ExtendedConnection(List<Edge<T>> edges, PageInfo pageInfo, long totalCount) {
        super(edges, pageInfo);
        this.totalCount = totalCount;
    }
}
