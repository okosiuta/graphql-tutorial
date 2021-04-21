package com.tutorial.graphql.graphqltutorial.graphql.resolver.review;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewResolver implements GraphQLResolver<Review> {

    private final UserService userService;
    private final BookService bookService;

    public Book getBook(Review review) {
        return bookService.findByReviewId(review.getId());
    }

    public User getUser(Review review) {
        return userService.findByReviewId(review.getId());
    }
}
