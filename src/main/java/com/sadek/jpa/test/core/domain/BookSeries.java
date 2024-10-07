package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BookSeries extends BaseEntity<Long> {
    @Column(name = "numberOfVersions")
    private Integer numberOfVersions;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_series_authors",
            uniqueConstraints = @UniqueConstraint(columnNames = {"book_series_id", "author_id"}),
            joinColumns = @JoinColumn(name = "book_series_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

}
