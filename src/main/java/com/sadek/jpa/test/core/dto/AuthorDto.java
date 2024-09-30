package com.sadek.jpa.test.core.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String author_name;
    private String nationality;
    private Integer age;

}
