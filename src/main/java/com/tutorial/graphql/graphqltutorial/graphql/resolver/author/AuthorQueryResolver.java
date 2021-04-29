package com.tutorial.graphql.graphqltutorial.graphql.resolver.author;

import com.tutorial.graphql.graphqltutorial.facade.AuthorApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorApi api;

    public Author findAuthorById(long id) {
        return api.findById(id);
    }

    public List<Author> findAllAuthors() {
        return api.findAll();
    }
}
