package com.tutorial.graphql.graphqltutorial.graphql.resolver.book;

import com.tutorial.graphql.graphqltutorial.facade.BookApi;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookApi api;

    public Book findBookById(long id) {
        return api.findById(id);
    }

    public List<Book> findAllBooks() {
        return api.findAll();
    }
}
