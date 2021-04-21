package com.tutorial.graphql.graphqltutorial.graphql.resolver.user;

import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService service;

    public User userById(long id) {
        return service.findById(id).orElseThrow();
    }

    public List<User> users() {
        return service.findAll();
    }
}
