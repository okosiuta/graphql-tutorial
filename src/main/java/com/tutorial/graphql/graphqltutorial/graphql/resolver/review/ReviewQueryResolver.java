package com.tutorial.graphql.graphqltutorial.graphql.resolver.review;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewQueryResolver implements GraphQLQueryResolver {

    private final ReviewService service;

    public Review reviewById(long id) {
        return service.findById(id).orElseThrow();
    }

    public List<Review> reviews() {
        return service.findAll();
    }
}
