package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r From Review r " +
            "JOIN FETCH r.book b " +
            "WHERE b.id in :ids")
    List<Review> findAllByBookIds(Collection<Long> ids);

    @Query("SELECT r From Review r " +
            "JOIN FETCH r.user u " +
            "WHERE u.id in :ids")
    List<Review> findAllByUserIds(Collection<Long> ids);

    @Query("SELECT r From Review r " +
            "WHERE r.id > :cursor")
    Page<Review> findAll(long cursor, Pageable pageable);

    boolean existsByIdIsBefore(long id);

    boolean existsByIdIsAfter(long id);
}
