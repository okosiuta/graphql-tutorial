package com.tutorial.graphql.graphqltutorial.graphql.resolver.book;

import com.tutorial.graphql.graphqltutorial.api.BookApi;
import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookApi api;

    public Book getBookById(long id) {
        return api.getById(id);
    }

    public List<Book> getAllBooks() {
        return api.getAll();
    }

    public Page<Book> getBookPageResult(int page, int size) {
        return api.getBookPageResult(page, size);
    }

    public ExtendedConnection<Book> getBookConnection(int first, String after) {
        return api.getBookConnection(first, after);
    }
}
