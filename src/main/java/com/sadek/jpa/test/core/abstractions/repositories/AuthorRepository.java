package com.sadek.jpa.test.core.abstractions.repositories;

import com.sadek.jpa.test.core.domain.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BaseRepository<Author, Long> {
}
