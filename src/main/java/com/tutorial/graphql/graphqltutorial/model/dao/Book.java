package com.tutorial.graphql.graphqltutorial.model.dao;

import com.tutorial.graphql.graphqltutorial.enumeration.BookGenre;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"authors", "reviews"})
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToMany(cascade = {MERGE, PERSIST})
    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors = new HashSet<>();

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Review> reviews = new HashSet<>();

    @Enumerated(STRING)
    private BookGenre genre;

    private String name;
    private String description;
}
