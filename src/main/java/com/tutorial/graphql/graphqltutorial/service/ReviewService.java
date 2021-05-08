package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Review save(Review review);

    Optional<Review> findById(long id);

    List<Review> findAll();

    Page<Review> findAll(long cursor, Pageable pageable);

    Page<Review> findAll(Pageable pageable);

    List<Review> findAllByBookIds(Collection<Long> ids);

    List<Review> findAllByUserIds(Collection<Long> ids);

    boolean hasWithIdBefore(long id);

    boolean hasWithIdAfter(long id);
}
