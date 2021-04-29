package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author save(Author author);

    Optional<Author> findById(long id);

    Optional<Author> findByIdWithBooks(long authorId);

    List<Author> findAll();

    List<Author> findAllByIds(Collection<Long> ids);

    List<Author> findAllByBookIds(List<Long> ids);
}
