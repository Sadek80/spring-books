package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author extends BaseEntity<Long> {

    private String name;
    private String nationality;
    private Integer age;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Book> books = new HashSet<>();
}
