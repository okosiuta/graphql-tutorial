package com.tutorial.graphql.graphqltutorial.graphql.mutation;

import com.tutorial.graphql.graphqltutorial.api.UserApi;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserApi api;

    public User createUser(User user) {
        return api.create(user);
    }
}
