package com.sadek.jpa.test.core.abstractions.repositories;

import com.sadek.jpa.test.core.domain.BookRate;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRateRepository extends BaseRepository<BookRate, Long>{
}
