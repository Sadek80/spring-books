package com.sadek.jpa.test.core.mappers;

import com.sadek.jpa.test.core.domain.Book;
import com.sadek.jpa.test.core.dto.BookDto;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {AuthorMapper.class})
public interface BookMapper {

    BookDto ToBookDto(Book book);

    Book FromBookDto(BookDto bookDto);


}
