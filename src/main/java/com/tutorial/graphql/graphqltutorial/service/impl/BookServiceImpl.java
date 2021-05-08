package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.repository.BookRepository;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Optional<Book> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> findAll(long cursor, Pageable pageable) {
        return repository.findAll(cursor, pageable);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Book> findAllByAuthorIds(Collection<Long> ids) {
        return repository.findAllByAuthorIds(ids);
    }

    @Override
    public List<Book> findAllByReviewIds(Collection<Long> ids) {
        return repository.findAllByReviewIds(ids);
    }

    @Override
    public List<Book> findAllByIds(Collection<Long> ids) {
        return repository.findAllById(ids);
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
