package com.tutorial.graphql.graphqltutorial.custom.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.custom.dataloader.NamedDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.REVIEWS_BY_USER_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class UserReviewDataLoader implements NamedDataLoader<Long, Collection<Review>> {

    private final ReviewService reviewService;

    @Override
    public CompletionStage<List<Collection<Review>>> load(List<Long> ids) {
        return supplyAsync(() -> {
            var reviews = reviewService.findAllByUserIds(ids);
            var groupedReviews = reviews.stream()
                    .collect(Collectors.groupingBy(review -> review.getBook().getId()));

            return ids.stream()
                    .map(userId -> groupedReviews.getOrDefault(userId, List.of()))
                    .collect(Collectors.toList());
        });
    }

    @Override
    public String getLoaderName() {
        return REVIEWS_BY_USER_IDS;
    }
}
