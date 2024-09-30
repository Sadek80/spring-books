package com.sadek.jpa.test.core.dto;

import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;
import java.util.Date;

@Data
@Builder()
public class BookDto {
    private Long id;
    private String name;
    private String isbn;

    private AuthorDto author;
}
