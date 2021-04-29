package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b " +
            "JOIN FETCH b.authors a " +
            "WHERE b.id = :id")
    Optional<Book> findByIdWithAuthors(long id);

    @Query("SELECT b FROM Book b " +
            "JOIN FETCH b.authors a " +
            "WHERE a.id IN :ids")
    List<Book> findAllByAuthorIds(List<Long> ids);

    @Query("SELECT b FROM Book b " +
            "JOIN FETCH b.reviews r " +
            "WHERE r.id IN :ids")
    List<Book> findAllByReviewIds(List<Long> ids);
}
