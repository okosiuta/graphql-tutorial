package com.tutorial.graphql.graphqltutorial.graphql.resolver.author;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import com.tutorial.graphql.graphqltutorial.service.BookService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private final BookService bookService;

    public List<Book> getBooks(Author author) {
        return bookService.findAllByAuthorId(author.getId());
    }
}
