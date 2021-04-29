package com.tutorial.graphql.graphqltutorial.facade;

import com.tutorial.graphql.graphqltutorial.model.dao.User;

import java.util.List;

public interface UserApi {

    User findById(long id);

    List<User> findAll();

    User create(User user);
}
