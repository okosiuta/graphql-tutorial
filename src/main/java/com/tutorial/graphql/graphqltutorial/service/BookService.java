package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book);

    Optional<Book> findById(long id);

    List<Book> findAll();

    Page<Book> findAll(long cursor, Pageable pageable);

    Page<Book> findAll(Pageable pageable);

    List<Book> findAllByAuthorIds(Collection<Long> ids);

    List<Book> findAllByReviewIds(Collection<Long> ids);

    List<Book> findAllByIds(Collection<Long> ids);

    boolean hasWithIdBefore(long id);

    boolean hasWithIdAfter(long id);
}
