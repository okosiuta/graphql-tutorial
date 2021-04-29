package com.tutorial.graphql.graphqltutorial.graphql.mutation;

import com.tutorial.graphql.graphqltutorial.facade.AuthorApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AuthorMutation implements GraphQLMutationResolver {

    private final AuthorApi api;

    public Author createAuthor(Author author) {
        return api.create(author);
    }

    public Author addAuthorBooks(long authorId, Set<Long> bookIds) {
        return api.addAuthorBooks(authorId, bookIds);
    }
}
