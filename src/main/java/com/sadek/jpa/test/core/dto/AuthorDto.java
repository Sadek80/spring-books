package com.sadek.jpa.test.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String author_name;
    private String nationality;
    private Integer age;

    public AuthorDto(Long id, String name, String nationality, Integer age) {
        this.id = id;
        this.author_name = name;
        this.nationality = nationality;
        this.age = age;
    }
}
