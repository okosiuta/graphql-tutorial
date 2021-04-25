package com.tutorial.graphql.graphqltutorial.repository;

import com.tutorial.graphql.graphqltutorial.model.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b From Book b " +
            "JOIN FETCH b.authors a " +
            "WHERE a.id in :ids")
    List<Book> findAllByAuthorIds(List<Long> ids);

    @Query("SELECT b From Book b " +
            "JOIN FETCH b.reviews r " +
            "WHERE r.id in :ids")
    List<Book> findAllByReviewIds(List<Long> ids);
}
