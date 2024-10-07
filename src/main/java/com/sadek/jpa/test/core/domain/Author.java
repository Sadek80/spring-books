package com.sadek.jpa.test.core.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sadek.jpa.test.core.abstractions.BaseEntity;
import com.sadek.jpa.test.core.abstractions.repositories.AuthorRepository;
import jakarta.persistence.*;
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

@NamedQueries({
        @NamedQuery(
                name = Author.TEST_NAMED_QUERY_NAME,
                query = Author.TEST_NAMED_QUERY
        ),
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = Author.TEST_NAMED_QUERY_NATIVE_NAME,
                query = Author.TEST_NAMED_NATIVE_QUERY,
                resultClass = Author.class
        )
})

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = Author.TEST_NAMED_GRAPH_NAME,
                attributeNodes = {
                        @NamedAttributeNode(Author.TEST_NAMED_GRAPH_VAL)
                }
        )
})
public class Author extends BaseEntity<Long> {
    public static final String TEST_NAMED_QUERY_NAME = "test-named-query";
    public static final String TEST_NAMED_QUERY = "SELECT a FROM Author a WHERE a.id = :id AND a.isDeleted = false";

    public static final String TEST_NAMED_QUERY_NATIVE_NAME = "test-named-native-query";
    public static final String TEST_NAMED_NATIVE_QUERY = "SELECT * FROM Author a WHERE a.id = ?1 AND a.is_deleted = false";

    public static final String TEST_NAMED_GRAPH_NAME = "test-named-graph";
    public static final String TEST_NAMED_GRAPH_VAL = "books";

    private String name;
    private String nationality;
    private Integer age;

    public Author(String name, String nationality, Integer age, Set<Book> books){
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.books = books;
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_series_authors",
            uniqueConstraints = @UniqueConstraint(columnNames = {"book_series_id", "author_id"}),
            joinColumns = @JoinColumn(name = "book_series_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<BookSeries> bookSeries = new HashSet<>();

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }

}
