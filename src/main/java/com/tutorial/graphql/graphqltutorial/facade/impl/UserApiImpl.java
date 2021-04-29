package com.tutorial.graphql.graphqltutorial.facade.impl;

import com.tutorial.graphql.graphqltutorial.custom.exception.ResourceNotFoundException;
import com.tutorial.graphql.graphqltutorial.facade.UserApi;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tutorial.graphql.graphqltutorial.constant.ErrorMessage.RESOURCE_NOT_FOUND;
import static com.tutorial.graphql.graphqltutorial.constant.GeneralConstant.USERS;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserService userService;

    @Override
    public User findById(long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(format(RESOURCE_NOT_FOUND, USERS, id)));
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User create(User user) {
        return userService.save(user);
    }
}
