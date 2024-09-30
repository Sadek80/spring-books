package com.sadek.jpa.test.core.abstractions.repositories;

import com.sadek.jpa.test.core.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
}
