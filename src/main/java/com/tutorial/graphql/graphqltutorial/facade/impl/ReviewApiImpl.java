package com.tutorial.graphql.graphqltutorial.facade.impl;

import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.facade.ReviewApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.*;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ReviewApiImpl implements ReviewApi {

    private final ReviewService reviewService;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public Review findById(long id) {
        return reviewService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, REVIEWS, id)));
    }

    @Override
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    public Review create(long userId, long bookId, String text) {
        var book = findBookById(bookId);
        var user = findUserById(userId);
        var review = Review.builder()
                .book(book)
                .user(user)
                .text(text)
                .build();

        return reviewService.save(review);
    }

    private Book findBookById(long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, BOOKS, id)));
    }

    private User findUserById(long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, USERS, id)));
    }
}
