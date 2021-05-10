package com.tutorial.graphql.graphqltutorial.graphql.subscription;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewSubscription implements GraphQLSubscriptionResolver {

    private final AbstractPublisher<Review> publisher;

    public Publisher<Review> getNewReviews() {
        return publisher.getPublisher();
    }
}
