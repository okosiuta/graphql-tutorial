package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a " +
            "JOIN FETCH a.books b " +
            "WHERE b.id IN :ids")
    List<Author> findAllByBooksIdIn(Collection<Long> ids);

    @Query("SELECT a FROM Author a " +
            "WHERE a.id > :cursor")
    Page<Author> findAll(long cursor, Pageable pageable);

    boolean existsByIdIsBefore(long id);

    boolean existsByIdIsAfter(long id);
}
