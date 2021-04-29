package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    Book save(Book book);

    Optional<Book> findById(long id);

    Optional<Book> findByIdWithAuthors(long id);

    List<Book> findAll();

    List<Book> findAllByAuthorIds(List<Long> ids);

    List<Book> findAllByReviewIds(List<Long> ids);

    List<Book> findAllByIds(Set<Long> ids);
}
