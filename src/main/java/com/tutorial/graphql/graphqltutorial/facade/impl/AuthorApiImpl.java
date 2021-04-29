package com.tutorial.graphql.graphqltutorial.facade.impl;

import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.facade.AuthorApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.AUTHORS;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AuthorApiImpl implements AuthorApi {

    private final AuthorService authorService;
    private final BookService bookService;

    @Override
    public Author findById(long id) {
        return authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, AUTHORS, id)));
    }

    @Override
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @Override
    public Author create(Author author) {
        return authorService.save(author);
    }

    @Override
    public Author addAuthorBooks(long authorId, Set<Long> bookIds) {
        var author = findById(authorId);
        var books = bookService.findAllByIds(bookIds);

        author.getBooks().addAll(books);

        return authorService.save(author);
    }
}
