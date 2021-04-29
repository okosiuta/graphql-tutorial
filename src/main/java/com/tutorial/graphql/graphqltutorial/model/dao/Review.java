package com.tutorial.graphql.graphqltutorial.model.dao;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"user", "book"})
public class Review {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    private String text;
}
