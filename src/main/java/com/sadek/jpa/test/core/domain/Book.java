package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        indexes = {
                @Index(name = "idx_book_isbn", columnList = "isbn", unique = true),
                @Index(name = "idx_book_author_id", columnList = "author_id")
        }
)
public class Book extends BaseEntity<Long>
{
    private String name;

    @Nullable
    private String isbn;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private  Author author;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "book")
    private BookRate rate;
}
