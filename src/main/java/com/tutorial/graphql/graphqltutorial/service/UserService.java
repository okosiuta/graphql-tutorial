package com.tutorial.graphql.graphqltutorial.service;

import com.tutorial.graphql.graphqltutorial.model.dao.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(long id);

    List<User> findAll();

    List<User> findAllByReviewIds(List<Long> ids);
}
