package com.tutorial.graphql.graphqltutorial.graphql.resolver.review;

import com.tutorial.graphql.graphqltutorial.facade.ReviewApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryResolver implements GraphQLQueryResolver {

    private final ReviewApi api;

    public Review findReviewById(long id) {
        return api.findById(id);
    }

    public List<Review> findAllReviews() {
        return api.findAll();
    }
}
