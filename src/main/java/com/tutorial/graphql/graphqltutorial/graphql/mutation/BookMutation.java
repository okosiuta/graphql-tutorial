package com.tutorial.graphql.graphqltutorial.graphql.mutation;

import com.tutorial.graphql.graphqltutorial.api.BookApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class BookMutation implements GraphQLMutationResolver {

    private final BookApi api;

    public Book createBook(Book book) {
        return api.create(book);
    }

    public Book addBookAuthors(long bookId, Set<Long> authorIds) {
        return api.addBookAuthors(bookId, authorIds);
    }
}
