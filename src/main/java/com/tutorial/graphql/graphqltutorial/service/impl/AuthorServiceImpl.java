package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.repository.AuthorRepository;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Optional<Author> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Author> findAll(long cursor, Pageable pageable) {
        return repository.findAll(cursor, pageable);
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Author> findAllByIds(Collection<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public List<Author> findAllByBookIds(Collection<Long> ids) {
        return repository.findAllByBooksIdIn(ids);
    }

    @Override
    public boolean hasWithIdBefore(long id) {
        return repository.existsByIdIsBefore(id);
    }

    @Override
    public boolean hasWithIdAfter(long id) {
        return repository.existsByIdIsAfter(id);
    }
}
