package com.example.demo.controllers;

import com.example.demo.domain.Author;
import com.example.demo.dtos.AuthorDto;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<Iterable<Author>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.list());
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> create(@RequestBody AuthorDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(dto.getName()));
    }
}
