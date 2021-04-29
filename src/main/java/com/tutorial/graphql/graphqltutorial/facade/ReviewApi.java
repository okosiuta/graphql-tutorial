package com.tutorial.graphql.graphqltutorial.facade;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;

import java.util.List;

public interface ReviewApi {

    Review findById(long id);

    List<Review> findAll();

    Review create(long userId, long bookId, String text);
}
