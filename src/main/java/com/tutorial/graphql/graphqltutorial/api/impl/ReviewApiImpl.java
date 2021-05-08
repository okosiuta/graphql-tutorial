package com.tutorial.graphql.graphqltutorial.api.impl;

import com.tutorial.graphql.graphqltutorial.api.ReviewApi;
import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import graphql.relay.DefaultEdge;
import graphql.relay.DefaultPageInfo;
import graphql.relay.Edge;
import graphql.relay.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.*;
import static com.tutorial.graphql.graphqltutorial.util.ConnectionUtils.from;
import static com.tutorial.graphql.graphqltutorial.util.ConnectionUtils.getCursor;
import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.util.CollectionUtils.firstElement;
import static org.springframework.util.CollectionUtils.lastElement;

@Service
@RequiredArgsConstructor
public class ReviewApiImpl implements ReviewApi {

    private final ReviewService reviewService;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public Review getById(long id) {
        return reviewService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, REVIEWS, id)));
    }

    @Override
    public List<Review> getAll() {
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

    @Override
    public Page<Review> getReviewPageResult(int page, int size) {
        return reviewService.findAll(of(page, size));
    }

    @Override
    public ExtendedConnection<Review> getReviewConnection(int first, String after) {
        var page = getReviewsByCursor(after, of(0, first));
        List<Edge<Review>> edges = page.get()
                .map(review -> new DefaultEdge<>(review, from(review.getId())))
                .collect(Collectors.toList());

        return new ExtendedConnection<>(edges, createPageInfo(edges), page.getTotalElements());
    }

    private Page<Review> getReviewsByCursor(String after, Pageable pageable) {
        return isBlank(after)
                ? reviewService.findAll(pageable)
                : reviewService.findAll(from(after), pageable);
    }

    private PageInfo createPageInfo(List<Edge<Review>> edges) {
        var firstElement = firstElement(edges);
        var lastElement = lastElement(edges);

        return new DefaultPageInfo(getCursor(firstElement), getCursor(lastElement), hasReviewsWithIdBefore(firstElement),
                hasReviewsWithIdAfter(lastElement));
    }

    private boolean hasReviewsWithIdBefore(Edge<Review> edge) {
        return nonNull(edge) && reviewService.hasWithIdBefore(edge.getNode().getId());
    }

    private boolean hasReviewsWithIdAfter(Edge<Review> edge) {
        return nonNull(edge) && reviewService.hasWithIdAfter(edge.getNode().getId());
    }
}
