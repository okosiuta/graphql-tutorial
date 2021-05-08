package com.tutorial.graphql.graphqltutorial.api;

import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface BookApi {

    Book getById(long id);

    List<Book> getAll();

    Book create(Book book);

    Book addBookAuthors(long bookId, Set<Long> authorIds);

    Page<Book> getBookPageResult(int page, int size);

    ExtendedConnection<Book> getBookConnection(int first, String after);
}
