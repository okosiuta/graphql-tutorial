package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b " +
            "JOIN FETCH b.authors a " +
            "WHERE a.id IN :ids")
    List<Book> findAllByAuthorIds(Collection<Long> ids);

    @Query("SELECT b FROM Book b " +
            "JOIN FETCH b.reviews r " +
            "WHERE r.id IN :ids")
    List<Book> findAllByReviewIds(Collection<Long> ids);

    @Query("SELECT b FROM Book b " +
            "WHERE b.id > :cursor")
    Page<Book> findAll(long cursor, Pageable pageable);

    boolean existsByIdIsBefore(long id);

    boolean existsByIdIsAfter(long id);
}
