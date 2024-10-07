package com.sadek.jpa.test.controllers;

import com.sadek.jpa.test.core.abstractions.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id)
    {
        var data = authorService.FindById(id);
        return data.isError() ? ResponseEntity.status(data.getStatusCode()).body(data) : ResponseEntity.ok(data);
    }

    @GetMapping
    public ResponseEntity<?> GetAll()
    {
        var data = authorService.TestJPA();
        return data.isError() ? ResponseEntity.status(data.getStatusCode()).body(data) : ResponseEntity.ok(data);
    }
}
