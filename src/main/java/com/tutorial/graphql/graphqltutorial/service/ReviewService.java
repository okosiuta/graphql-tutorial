package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<Review> findById(long id);

    List<Review> findAll();

    List<Review> findAllByBookId(long id);

    List<Review> findAllByUserId(long id);
}
