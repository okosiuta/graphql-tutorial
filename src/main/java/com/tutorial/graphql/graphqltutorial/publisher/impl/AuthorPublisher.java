package com.tutorial.graphql.graphqltutorial.publisher.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import static reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE;

@Component
public class AuthorPublisher extends AbstractPublisher<Author> {

    public AuthorPublisher() {
        super(Sinks.many().multicast().onBackpressureBuffer(SMALL_BUFFER_SIZE, false));
    }
}
