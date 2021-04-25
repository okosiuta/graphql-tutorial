package com.tutorial.graphql.graphqltutorial.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.dataloader.BatchDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.BOOKS_BY_REVIEW_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class ReviewBookDataLoader implements BatchDataLoader<Long, Book> {

    private final BookService bookService;

    @Override
    public CompletionStage<List<Book>> load(List<Long> ids) {
        return supplyAsync(() -> bookService.findAllByReviewIds(ids));
    }

    @Override
    public String getLoaderName() {
        return BOOKS_BY_REVIEW_IDS;
    }
}
