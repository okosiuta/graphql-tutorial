package com.tutorial.graphql.graphqltutorial.graphql.resolver.user;

import com.tutorial.graphql.graphqltutorial.facade.UserApi;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserApi api;

    public User findUserById(long id) {
        return api.findById(id);
    }

    public List<User> findAllUsers() {
        return api.findAll();
    }
}
