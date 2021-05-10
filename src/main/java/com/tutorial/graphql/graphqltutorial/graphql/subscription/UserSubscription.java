package com.tutorial.graphql.graphqltutorial.graphql.subscription;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSubscription implements GraphQLSubscriptionResolver {

    private final AbstractPublisher<User> publisher;

    public Publisher<User> getNewUsers() {
        return publisher.getPublisher();
    }
}
