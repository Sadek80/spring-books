package com.sadek.jpa.test.core.abstractions.repositories;

import com.sadek.jpa.test.core.domain.Author;
import com.sadek.jpa.test.core.dto.AuthorDto;
import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface AuthorRepository extends BaseRepository<Author, Long> {



    //D-SQL
    Author findByName(String name);

    //JPQL

    @Query("SELECT a FROM Author a WHERE a.id = ?1")
    Author getAuthorJPQL(Long id);

    @Query("SELECT a FROM Author a WHERE a.id = :author_id")
    Author getAuthorJPQLParam(@Param("author_id") Long id);

//    @Query("SELECT new com.sadek.jpa.test.core.dto.AuthorDto(a.id, a.name, a.nationality, a.age) " +
//            "FROM Author a WHERE a.id = :author_id")
//    AuthorDto getAuthorJPQLProjection(@Param("author_id") Long id);

    // N+1
    @Query("SELECT a FROM Author a JOIN FETCH a.books WHERE a.isDeleted = false AND a.id = ?1")
    Author getAuthorWithBooks(Long id);

    @EntityGraph(attributePaths = {"books", "books.rate"})
    Author findByIdAndIsDeletedFalse(Long id);

    @EntityGraph(value = Author.TEST_NAMED_GRAPH_NAME)
    Author findByIdAndIsDeletedIsFalse(Long id);

    // Native Query
    @Query(value = "SELECT * FROM Author a WHERE a.id = ?1 AND a.is_deleted = false", nativeQuery = true)
    Author getAuthorNative(Long id);

    //NAMED
    @Query(name = Author.TEST_NAMED_QUERY_NAME)
    Author getNamedQuery(Long id);

    @Query(name = Author.TEST_NAMED_QUERY_NATIVE_NAME, nativeQuery = true)
    Author getNamedNativeQuery(Long id);

}
