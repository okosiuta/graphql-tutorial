package com.tutorial.graphql.graphqltutorial.facade;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;

import java.util.List;
import java.util.Set;

public interface BookApi {

    Book findById(long id);

    List<Book> findAll();

    Book create(Book book);

    Book addBookAuthors(long bookId, Set<Long> authorIds);
}
