package com.tutorial.graphql.graphqltutorial.graphql.resolver.review;

import com.tutorial.graphql.graphqltutorial.api.ReviewApi;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryResolver implements GraphQLQueryResolver {

    private final ReviewApi api;

    public Review getReviewById(long id) {
        return api.getById(id);
    }

    public List<Review> getAllReviews() {
        return api.getAll();
    }

    public Page<Review> getReviewPageResult(int page, int size) {
        return api.getReviewPageResult(page, size);
    }

    public ExtendedConnection<Review> getReviewConnection(int first, String after) {
        return api.getReviewConnection(first, after);
    }
}
