package com.tutorial.graphql.graphqltutorial.graphql.subscription;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorSubscription implements GraphQLSubscriptionResolver {

    private final AbstractPublisher<Author> publisher;

    public Publisher<Author> getNewAuthors() {
        return publisher.getPublisher();
    }
}
