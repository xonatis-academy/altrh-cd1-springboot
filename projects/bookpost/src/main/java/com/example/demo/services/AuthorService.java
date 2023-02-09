package com.example.demo.services;

import com.example.demo.domain.Author;
import com.example.demo.providers.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> list() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author create(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

}
