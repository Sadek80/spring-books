package com.sadek.jpa.test.service;

import com.sadek.jpa.test.core.abstractions.repositories.AuthorRepository;
import com.sadek.jpa.test.core.abstractions.services.AuthorService;
import com.sadek.jpa.test.core.domain.Author;
import com.sadek.jpa.test.core.dto.AuthorDto;
import com.sadek.jpa.test.core.helpers.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    void findById_NotFoundAuthor_ShouldReturnErrorResponse(){
        //Arrange
        Optional<Author> mockedAuthor = Optional.empty();
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(mockedAuthor);

        //Act
        var authorResponse = authorService.FindById((long)100);

        //Assert
        assertTrue(authorResponse.isError());
    }

    @Test
    void findById_NotFoundAuthor_ShouldReturnErrorResponse404(){
        //Arrange
        Optional<Author> mockedAuthor = Optional.empty();
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(mockedAuthor);

        //Act
        var authorResponse = authorService.FindById((long)100);

        //Assert
        assertEquals(404, authorResponse.getStatusCode());
    }

    @Test
    void findById_FoundAuthor_ShouldReturnSuccessResponse(){
        //Arrange
        Optional<Author> mockedAuthor = Optional.of(new Author("sadek", "Egypt", 20, null));
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(mockedAuthor);

        //Act
        var authorResponse = authorService.FindById((long)100);

        //Assert
        assertFalse(authorResponse.isError());
    }

    @Test
    void findById_FoundAuthor_ShouldReturnResponse200(){
        //Arrange
        Optional<Author> mockedAuthor = Optional.of(new Author("sadek", "Egypt", 20, null));
        Mockito.when(authorRepository.findById(Mockito.anyLong()))
                .thenReturn(mockedAuthor);

        //Act
        var authorResponse = authorService.FindById((long)100);

        //Assert
        assertEquals(200, authorResponse.getStatusCode());
    }
}
