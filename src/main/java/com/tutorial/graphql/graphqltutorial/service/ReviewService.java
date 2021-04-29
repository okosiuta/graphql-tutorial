package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Review save(Review review);

    Optional<Review> findById(long id);

    List<Review> findAll();

    List<Review> findAllByBookIds(List<Long> ids);

    List<Review> findAllByUserIds(List<Long> ids);
}
