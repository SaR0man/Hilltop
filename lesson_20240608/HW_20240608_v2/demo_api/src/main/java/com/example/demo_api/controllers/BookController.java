package com.example.demo_api.controllers;

import com.example.demo_api.entities.Book;
import com.example.demo_api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(book -> System.out.println(book.getName()));
        return bookService.getAllBooks();
    }
}
