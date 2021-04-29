package com.tutorial.graphql.graphqltutorial.facade.impl;

import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.facade.BookApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.BOOKS;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class BookApiImpl implements BookApi {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public Book findById(long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, BOOKS, id)));
    }

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public Book create(Book book) {
        return bookService.save(book);
    }

    @Override
    public Book addBookAuthors(long bookId, Set<Long> authorIds) {
        var book = findById(bookId);
        var authors = authorService.findAllByIds(authorIds);

        book.getAuthors().addAll(authors);

        return bookService.save(book);
    }
}
