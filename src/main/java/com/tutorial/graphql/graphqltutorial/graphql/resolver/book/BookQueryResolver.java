package com.tutorial.graphql.graphqltutorial.graphql.resolver.book;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookService service;

    public Book bookById(long id) {
        return service.findById(id).orElseThrow();
    }

    public List<Book> books() {
        return service.findAll();
    }
}
