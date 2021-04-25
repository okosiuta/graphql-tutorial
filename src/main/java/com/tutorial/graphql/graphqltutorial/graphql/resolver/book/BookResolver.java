package com.tutorial.graphql.graphqltutorial.graphql.resolver.book;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.AUTHORS_BY_BOOK_IDS;
import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.REVIEWS_BY_BOOK_IDS;

@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    public CompletableFuture<Collection<Author>> getAuthors(Book book, DataFetchingEnvironment environment) {
        return environment.<Long, Collection<Author>>getDataLoader(AUTHORS_BY_BOOK_IDS)
                .load(book.getId());
    }

    public CompletableFuture<Collection<Review>> getReviews(Book book, DataFetchingEnvironment environment) {
        return environment.<Long, Collection<Review>>getDataLoader(REVIEWS_BY_BOOK_IDS)
                .load(book.getId());
    }
}
