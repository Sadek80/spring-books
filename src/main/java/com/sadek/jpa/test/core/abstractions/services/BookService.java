package com.sadek.jpa.test.core.abstractions.services;
import com.sadek.jpa.test.core.dto.BookDto;
import com.sadek.jpa.test.core.helpers.Response;

import java.util.List;

public interface BookService {
    Response<BookDto> FindById(Long id);
    Response<List<BookDto>> FindAll(Long id);
}
