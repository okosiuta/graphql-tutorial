package com.tutorial.graphql.graphqltutorial.api;

import com.tutorial.graphql.graphqltutorial.custom.pagination.ExtendedConnection;
import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface AuthorApi {

    Author getById(long id);

    List<Author> getAll();

    Author create(Author author);

    Author addAuthorBooks(long authorId, Set<Long> bookIds);

    Page<Author> getAuthorPageResult(int page, int size);

    ExtendedConnection<Author> getAuthorConnection(int first, String after);
}
