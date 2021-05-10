package com.tutorial.graphql.graphqltutorial.graphql.resolver.user;

import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.REVIEWS_BY_USER_IDS;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {

    public CompletableFuture<Collection<Review>> getReviews(User user, DataFetchingEnvironment environment) {
        return environment.<Long, Collection<Review>>getDataLoader(REVIEWS_BY_USER_IDS)
                .load(user.getId());
    }

    public DataFetcherResult<String> getPropertyFetchedFromNotReliableService(User user) {
        var resultBuilder = DataFetcherResult.<String>newResult();

        if ((int) (Math.random() * 10) + 1 <= 5) {
            resultBuilder.error(new GenericGraphQLError("Oh... Can't fetch 'propertyFetchedFromNotReliableService' :("));
        } else {
            resultBuilder.data("Finally! User data :)");
        }

        return resultBuilder
                .build();
    }
}
