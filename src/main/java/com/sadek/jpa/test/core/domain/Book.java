package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity<Long>
{
    private String name;
    private String isbn;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private  Author author;
}
