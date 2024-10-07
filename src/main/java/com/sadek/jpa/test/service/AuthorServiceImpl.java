package com.sadek.jpa.test.service;

import com.sadek.jpa.test.core.abstractions.repositories.AuthorRepository;
import com.sadek.jpa.test.core.abstractions.services.AuthorService;
import com.sadek.jpa.test.core.domain.Author;
import com.sadek.jpa.test.core.dto.AuthorDto;
import com.sadek.jpa.test.core.helpers.Response;
import com.sadek.jpa.test.core.mappers.AuthorMapper;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
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

    @Override
    public Response<?> TestJPA() {
        var author0 = authorRepository.findByName("sadek");
        log.warning("data is "+ author0);

        // 1.  D-SQL
        log.warning("Starting D-SQL");
        var author = authorRepository.getAuthorJPQL((long)1);

        log.warning("data is "+ author);

        // 2. JPQL Custom Query
        log.warning("Starting JPQL CUSTOM");

        var author2 = authorRepository.getAuthorJPQLParam((long)1);

        log.warning("data is "+ author2);

        // 3. JPQL custom query with param name
        log.warning("Starting JPQL WITH PARAM");

        var author3 = authorRepository.getAuthorJPQLParam((long)1);

        log.warning("data is "+ author3);


        //4. JPQL Projection
        log.warning("Starting DTO PROJECTION");

//        var author4 = authorRepository.getAuthorJPQLProjection((long)1);

        //5. n+1 with JOIN FETCH
        log.warning("Starting N+1 WITH JOIN FETCH");


        var author5 = authorRepository.getAuthorWithBooks((long)1);
        log.warning("data is "+ author5);


        //6. Entity Graph
        log.warning("Starting N+! WITH GRAPH");

        var author6 = authorRepository.findByIdAndIsDeletedFalse((long)1);

        log.warning("data is "+ author6);


        //7. Named Entity Graph
        log.warning("Starting N+1 WITH NAMED GRAPH");

        var author7 = authorRepository.findByIdAndIsDeletedIsFalse((long)1);

        log.warning("data is "+ author7);


        //8. Named Query
        log.warning("Starting NAMED QUERY");

        var author8 = authorRepository.getNamedQuery((long)1);

        log.warning("data is "+ author8);




        //10. Native Query
        log.warning("Starting NATIVE QUERY");

        var author10 = authorRepository.getAuthorNative((long)1);
        log.warning("data is "+ author10);


        //9. Native Named Query
        log.warning("Starting NAMED NATIVE QUERY");

        var author9 = authorRepository.getNamedNativeQuery((long)1);

        log.warning("data is "+ author9);


        //10. Test Sorting and Pagination
        log.warning("Starting Sorting and Pagination");

        var pageable = PageRequest.of(1, 10, Sort.by("name").descending().and(Sort.by("nationality").descending()));

        Page<Author> author11 = authorRepository.findAll(pageable);

        log.warning(""+author11.getContent());

        //11. Test Sorting and Pagination
        log.warning("Starting Sorting and Pagination with orders");

        var orders = new ArrayList<Sort.Order>();

        orders.add(new Sort.Order(Sort.Direction.DESC, "name"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "Nationality"));

        var pageNumber = 1;
        var pageSize = 10;

        var pageable2 = PageRequest.of(0, 10, Sort.by(orders));

        var author12 = authorRepository.findAll(pageable2);

        var response = authorMapper.ToAuthorDtoList(author12.toList());

        return new Response<>(response, null, 200);
    }


}
