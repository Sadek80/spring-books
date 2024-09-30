package com.sadek.jpa.test.core.mappers;

import com.sadek.jpa.test.core.domain.Author;
import com.sadek.jpa.test.core.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Mappings({
            @Mapping(target = "author_name", source = "name")
    })
    AuthorDto ToAuthorDto(Author author);

    List<AuthorDto> ToAuthorDtoList(List<Author> authors);

    @Mappings({
            @Mapping(source = "author_name", target = "name")
    })
    Author FromAuthorDto(AuthorDto author);

    List<Author> FromAuthorDtoList(List<AuthorDto> authors);

}
