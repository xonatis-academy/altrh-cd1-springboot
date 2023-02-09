package com.example.demo.controllers;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.dtos.AddAuthorToBookDto;
import com.example.demo.dtos.BookDto;
import com.example.demo.services.BookService;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.list());
    }

    @PostMapping("/books")
    public ResponseEntity<Book> create(@RequestBody BookDto dto) {
        Author author = authorService.findAuthorById(dto.getAuthorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(dto.getTitle(), author));
    }

    @PostMapping("/books/{id}/authors")
    public ResponseEntity<Book> addAuthor(@PathVariable int id, @RequestBody AddAuthorToBookDto dto) {
        Author author = authorService.findAuthorById(dto.getCoAuthorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addAuthor(id, author));
    }
}
