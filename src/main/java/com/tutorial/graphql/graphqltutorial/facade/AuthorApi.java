package com.tutorial.graphql.graphqltutorial.facade;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;

import java.util.List;
import java.util.Set;

public interface AuthorApi {

    Author findById(long id);

    List<Author> findAll();

    Author create(Author author);

    Author addAuthorBooks(long authorId, Set<Long> bookIds);
}
