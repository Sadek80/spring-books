package com.sadek.jpa.test.service;

import com.sadek.jpa.test.core.abstractions.repositories.AuthorRepository;
import com.sadek.jpa.test.core.abstractions.services.AuthorService;
import com.sadek.jpa.test.core.dto.AuthorDto;
import com.sadek.jpa.test.core.helpers.Response;
import com.sadek.jpa.test.core.mappers.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Response<AuthorDto> FindById(Long id) {
        var author = authorRepository.findById(id);

        if (author.isEmpty()){
            return new Response<AuthorDto>("not found", 404);
        }

        var result = authorMapper.ToAuthorDto(author.get());

        return new Response<AuthorDto>(result, "Success", 200);
    }

    @Override
    public Response<List<AuthorDto>> FindAll() {
        var authors = authorRepository.findAll();

        if (authors.isEmpty()){
            return new Response<List<AuthorDto>>("not found", 404);
        }

        var result = authorMapper.ToAuthorDtoList(authors);

        return new Response<List<AuthorDto>>(result, "Success", 200);
    }
}
