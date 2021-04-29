package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a " +
            "JOIN FETCH a.books b " +
            "WHERE b.id IN :ids")
    List<Author> findAllByBooksIdIn(List<Long> ids);

    @Query("SELECT a FROM Author a " +
            "JOIN FETCH a.books b " +
            "WHERE a.id = :id")
    Optional<Author> findByIdWithBooks(long id);
}
