package com.tutorial.graphql.graphqltutorial.api;

import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewApi {

    Review getById(long id);

    List<Review> getAll();

    Review create(long userId, long bookId, String text);

    Page<Review> getReviewPageResult(int page, int size);

    ExtendedConnection<Review> getReviewConnection(int first, String after);
}
