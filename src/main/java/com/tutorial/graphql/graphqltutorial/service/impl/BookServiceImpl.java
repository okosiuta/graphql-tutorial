package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.repository.BookRepository;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public Optional<Book> findByIdWithAuthors(long id) {
        return repository.findByIdWithAuthors(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findAllByAuthorIds(List<Long> ids) {
        return repository.findAllByAuthorIds(ids);
    }

    @Override
    public List<Book> findAllByReviewIds(List<Long> ids) {
        return repository.findAllByReviewIds(ids);
    }

    @Override
    public List<Book> findAllByIds(Set<Long> ids) {
        return repository.findAllById(ids);
    }
}
