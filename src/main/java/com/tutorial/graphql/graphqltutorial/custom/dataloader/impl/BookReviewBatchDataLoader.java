package com.tutorial.graphql.graphqltutorial.custom.dataloader.impl;

import com.tutorial.graphql.graphqltutorial.custom.dataloader.NamedBatchDataLoader;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.tutorial.graphql.graphqltutorial.constant.DataLoaderName.REVIEWS_BY_BOOK_IDS;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Component
@RequiredArgsConstructor
public class BookReviewBatchDataLoader implements NamedBatchDataLoader<Long, Collection<Review>> {

    private final ReviewService reviewService;

    @Override
    public CompletionStage<List<Collection<Review>>> load(List<Long> ids) {
        return supplyAsync(() -> {
            var reviews = reviewService.findAllByBookIds(ids);
            var groupedReviews = reviews.stream()
                    .collect(Collectors.groupingBy(review -> review.getBook().getId()));

            return ids.stream()
                    .map(bookId -> groupedReviews.getOrDefault(bookId, List.of()))
                    .collect(Collectors.toList());
        });
    }

    @Override
    public String getLoaderName() {
        return REVIEWS_BY_BOOK_IDS;
    }
}
