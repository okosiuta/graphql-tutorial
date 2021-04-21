package com.tutorial.graphql.graphqltutorial.graphql.resolver.author;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorService service;

    public Author authorById(long id) {
        return service.findById(id).orElseThrow();
    }

    public List<Author> authors() {
        return service.findAll();
    }
}
