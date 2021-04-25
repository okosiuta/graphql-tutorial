package com.tutorial.graphql.graphqltutorial.graphql.resolver.review;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.BOOKS_BY_REVIEW_IDS;
import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.USERS_BY_REVIEW_IDS;

@Component
@RequiredArgsConstructor
public class ReviewResolver implements GraphQLResolver<Review> {

    public CompletableFuture<Book> getBook(Review review, DataFetchingEnvironment environment) {
        return environment.<Long, Book>getDataLoader(BOOKS_BY_REVIEW_IDS)
                .load(review.getId());
    }

    public CompletableFuture<User> getUser(Review review, DataFetchingEnvironment environment) {
        return environment.<Long, User>getDataLoader(USERS_BY_REVIEW_IDS)
                .load(review.getId());
    }
}
