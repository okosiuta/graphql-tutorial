package com.tutorial.graphql.graphqltutorial.graphql.subscription;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.publisher.AbstractPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSubscription implements GraphQLSubscriptionResolver {

    private final AbstractPublisher<Book> publisher;

    public Publisher<Book> getNewBooks() {
        return publisher.getPublisher();
    }
}
