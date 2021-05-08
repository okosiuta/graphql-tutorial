package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author save(Author author);

    Optional<Author> findById(long id);

    List<Author> findAll();

    Page<Author> findAll(long cursor, Pageable pageable);

    Page<Author> findAll(Pageable pageable);

    List<Author> findAllByIds(Collection<Long> ids);

    List<Author> findAllByBookIds(Collection<Long> ids);

    boolean hasWithIdBefore(long id);

    boolean hasWithIdAfter(long id);
}
