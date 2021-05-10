package com.tutorial.graphql.graphqltutorial.publisher.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class UserPublisher extends AbstractPublisher<User> {

    public UserPublisher() {
        super(Sinks.many().multicast().onBackpressureBuffer());
    }
}
