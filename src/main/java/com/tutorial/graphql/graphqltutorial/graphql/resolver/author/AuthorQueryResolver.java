package com.tutorial.graphql.graphqltutorial.graphql.resolver.author;

import com.tutorial.graphql.graphqltutorial.api.AuthorApi;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorApi api;

    public Author getAuthorById(long id) {
        return api.getById(id);
    }

    public List<Author> getAllAuthors() {
        return api.getAll();
    }

    public Page<Author> getAuthorPageResult(int page, int size) {
        return api.getAuthorPageResult(page, size);
    }

    public ExtendedConnection<Author> getAuthorConnection(int first, String after) {
        return api.getAuthorConnection(first, after);
    }
}
