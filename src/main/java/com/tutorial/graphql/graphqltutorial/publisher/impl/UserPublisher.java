package com.tutorial.graphql.graphqltutorial.publisher.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import static reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE;

@Component
public class UserPublisher extends AbstractPublisher<User> {

    public UserPublisher() {
        super(Sinks.many().multicast().onBackpressureBuffer(SMALL_BUFFER_SIZE, false));
    }
}
