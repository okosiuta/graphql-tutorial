package com.tutorial.graphql.graphqltutorial.model.dao;

import com.tutorial.graphql.graphqltutorial.enumeration.UserType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "`user`")
@EqualsAndHashCode(exclude = {"reviews"})
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Review> reviews = new HashSet<>();

    @Enumerated(value = STRING)
    private UserType type;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp default (now() at time zone 'utc')")
    private LocalDateTime createdAt;

    private String name;
}
