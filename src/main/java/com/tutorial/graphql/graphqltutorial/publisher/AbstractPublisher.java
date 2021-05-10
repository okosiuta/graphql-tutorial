package com.tutorial.graphql.graphqltutorial.publisher;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Sinks;

@RequiredArgsConstructor
public abstract class AbstractPublisher<T> {

    protected final Sinks.Many<T> sink;

    public void publish(T obj) {
        sink.tryEmitNext(obj);
    }

    public Publisher<T> getPublisher() {
        return sink.asFlux();
    }
}
