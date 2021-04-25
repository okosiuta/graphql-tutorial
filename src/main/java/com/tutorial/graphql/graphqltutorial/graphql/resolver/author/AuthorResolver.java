package com.tutorial.graphql.graphqltutorial.graphql.resolver.author;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.BOOKS_BY_AUTHOR_IDS;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    public CompletableFuture<Collection<Book>> getBooks(Author author, DataFetchingEnvironment environment) {
        return environment.<Long, Collection<Book>>getDataLoader(BOOKS_BY_AUTHOR_IDS)
                .load(author.getId());
    }
}
