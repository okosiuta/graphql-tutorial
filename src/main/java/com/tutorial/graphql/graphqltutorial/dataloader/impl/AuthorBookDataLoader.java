package com.tutorial.graphql.graphqltutorial.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.dataloader.BatchDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.BOOKS_BY_AUTHOR_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class AuthorBookDataLoader implements BatchDataLoader<Long, Collection<Book>> {

    private final BookService bookService;

    @Override
    public CompletionStage<List<Collection<Book>>> load(List<Long> ids) {
        return supplyAsync(() -> {
            var books = bookService.findAllByAuthorIds(ids);

            return ids.stream()
                    .map(bookId -> books.stream()
                            .filter(book -> book.getAuthors().stream()
                                    .map(Author::getId)
                                    .anyMatch(bookId::equals))
                            .collect(Collectors.toSet()))
                    .collect(Collectors.toList());
        });
    }

    @Override
    public String getLoaderName() {
        return BOOKS_BY_AUTHOR_IDS;
    }
}
