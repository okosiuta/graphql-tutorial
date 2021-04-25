package com.tutorial.graphql.graphqltutorial.service.impl;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.repository.ReviewRepository;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public Optional<Review> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Review> findAllByBookIds(List<Long> ids) {
        return repository.findAllByBookIds(ids);
    }

    @Override
    public List<Review> findAllByUserIds(List<Long> ids) {
        return repository.findAllByUserIds(ids);
    }
}
