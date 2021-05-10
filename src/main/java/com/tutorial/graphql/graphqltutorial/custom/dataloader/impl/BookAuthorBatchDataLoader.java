package com.tutorial.graphql.graphqltutorial.custom.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.custom.dataloader.NamedBatchDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.AUTHORS_BY_BOOK_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class BookAuthorBatchDataLoader implements NamedBatchDataLoader<Long, Collection<Author>> {

    private final AuthorService authorService;

    @Override
    public CompletionStage<List<Collection<Author>>> load(List<Long> ids) {
        return supplyAsync(() -> {
            var authors = authorService.findAllByBookIds(ids);

            return ids.stream()
                    .map(bookId -> authors.stream()
                            .filter(author -> author.getBooks().stream()
                                    .map(Book::getId)
                                    .anyMatch(bookId::equals))
                            .collect(Collectors.toSet()))
                    .collect(Collectors.toList());
        });
    }

    @Override
    public String getLoaderName() {
        return AUTHORS_BY_BOOK_IDS;
    }
}
