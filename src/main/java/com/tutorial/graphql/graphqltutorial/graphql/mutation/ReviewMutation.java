package com.tutorial.graphql.graphqltutorial.graphql.mutation;

import com.tutorial.graphql.graphqltutorial.api.ReviewApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMutation implements GraphQLMutationResolver {

    private final ReviewApi api;

    public Review createReview(long userId, long bookId, String text) {
        return api.create(userId, bookId, text);
    }
}
