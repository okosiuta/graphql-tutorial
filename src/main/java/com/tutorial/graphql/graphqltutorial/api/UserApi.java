package com.tutorial.graphql.graphqltutorial.api;

import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserApi {

    User getById(long id);

    List<User> getAll();

    User create(User user);

    Page<User> getUserPageResult(int page, int size);

    ExtendedConnection<User> getUserConnection(int first, String after);
}
