package com.tutorial.graphql.graphqltutorial.publisher.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class ReviewPublisher extends AbstractPublisher<Review> {

    public ReviewPublisher() {
        super(Sinks.many().multicast().onBackpressureBuffer());
    }
}
