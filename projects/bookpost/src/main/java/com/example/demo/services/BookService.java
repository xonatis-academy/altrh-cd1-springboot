package com.example.demo.services;

import com.example.demo.domain.Book;
import com.example.demo.domain.Author;
import com.example.demo.providers.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> list() {
        return bookRepository.findAll();
    }
    public Book create(String title, Author author) {
        Book book = new Book();
        book.setName(title);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);
        return bookRepository.save(book);
    }

    public Book addAuthor(int id, Author coAuthor) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        }
        Collection<Author> authors = book.getAuthors();
        authors.add(coAuthor);
        return bookRepository.save(book);
    }

}
