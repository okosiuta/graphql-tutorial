package com.tutorial.graphql.graphqltutorial.graphql.resolver.user;

import com.tutorial.graphql.graphqltutorial.api.UserApi;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserApi api;

    public User getUserById(long id) {
        return api.getById(id);
    }

    public List<User> getAllUsers() {
        return api.getAll();
    }

    public Page<User> getUserPageResult(int page, int size) {
        return api.getUserPageResult(page, size);
    }

    public ExtendedConnection<User> getUserConnection(int first, String after) {
        return api.getUserConnection(first, after);
    }
}
