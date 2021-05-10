package com.tutorial.graphql.graphqltutorial.model.dao;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @CreationTimestamp
    @Column(columnDefinition = "timestamp default (now() at time zone 'utc')")
    private LocalDateTime createdAt;

    private String name;
}
