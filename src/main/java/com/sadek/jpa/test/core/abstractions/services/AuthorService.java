package com.sadek.jpa.test.core.abstractions.services;
import com.sadek.jpa.test.core.dto.AuthorDto;
import com.sadek.jpa.test.core.helpers.Response;

import java.util.List;

public interface AuthorService {
    Response<AuthorDto> FindById(Long id);
    Response<List<AuthorDto>> FindAll();

    Response<?> TestJPA();
}
