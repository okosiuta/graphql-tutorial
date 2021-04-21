package com.tutorial.graphql.graphqltutorial.graphql.resolver.book;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.model.dao.Review;
import com.tutorial.graphql.graphqltutorial.service.AuthorService;
import com.tutorial.graphql.graphqltutorial.service.ReviewService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorService authorService;
    private final ReviewService reviewService;

    public List<Author> getAuthors(Book book) {
        return authorService.findAllByBookId(book.getId());
    }

    public List<Review> getReviews(Book book) {
        return reviewService.findAllByBookId(book.getId());
    }
}
