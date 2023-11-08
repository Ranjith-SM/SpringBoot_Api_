package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public List<Book> addBook(@RequestBody Book book) {
        return bookRepository.insert(book);
    }

    @PutMapping("/books")
    public List<Book> updateBook(@RequestBody Book book) {
        return bookRepository.update(book);
    }

    @DeleteMapping("/books/{id}")
    public List<Book> deleteBook(@PathVariable int id) {
        return bookRepository.delete(id);
    }

}
