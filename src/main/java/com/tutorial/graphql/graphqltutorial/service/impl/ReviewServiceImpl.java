package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.repository.ReviewRepository;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }

    @Override
    public Optional<Review> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Review> findAll(long cursor, Pageable pageable) {
        return repository.findAll(cursor, pageable);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Review> findAllByBookIds(Collection<Long> ids) {
        return repository.findAllByBookIds(ids);
    }

    @Override
    public List<Review> findAllByUserIds(Collection<Long> ids) {
        return repository.findAllByUserIds(ids);
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
