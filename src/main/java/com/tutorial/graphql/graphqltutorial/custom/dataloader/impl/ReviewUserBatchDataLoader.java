package com.tutorial.graphql.graphqltutorial.custom.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.custom.dataloader.NamedBatchDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.User;
import com.tutorial.graphql.graphqltutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.USERS_BY_REVIEW_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class ReviewUserBatchDataLoader implements NamedBatchDataLoader<Long, User> {

    private final UserService userService;

    @Override
    public CompletionStage<List<User>> load(List<Long> ids) {
        return supplyAsync(() -> userService.findAllByReviewIds(ids));
    }

    @Override
    public String getLoaderName() {
        return USERS_BY_REVIEW_IDS;
    }
}
