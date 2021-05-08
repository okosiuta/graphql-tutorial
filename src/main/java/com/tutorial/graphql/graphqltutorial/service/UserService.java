package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(long id);

    List<User> findAll();

    Page<User> findAll(long cursor, Pageable pageable);

    Page<User> findAll(Pageable pageable);

    List<User> findAllByReviewIds(Collection<Long> ids);

    boolean hasWithIdBefore(long id);

    boolean hasWithIdAfter(long id);
}
