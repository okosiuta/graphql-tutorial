package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u From User u " +
            "JOIN FETCH u.reviews r " +
            "WHERE r.id in :ids")
    List<User> findAllByReviewIds(Collection<Long> ids);

    @Query("SELECT u From User u " +
            "WHERE u.id > :cursor")
    Page<User> findAll(long cursor, Pageable pageable);

    boolean existsByIdIsBefore(long id);

    boolean existsByIdIsAfter(long id);
}
