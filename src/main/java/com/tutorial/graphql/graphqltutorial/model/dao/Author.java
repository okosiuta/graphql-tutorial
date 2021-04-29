package com.tutorial.graphql.graphqltutorial.model.dao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude = {"books"})
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "authors")
    private final Set<Book> books = new HashSet<>();

    private String name;
}
