package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(
        indexes = {
                @Index(name = "idx_book_rate_book_id", columnList = "book_id"),
        }
)
public class BookRate extends BaseEntity<Long> {
    private Integer rate;
    private String Source;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
}
