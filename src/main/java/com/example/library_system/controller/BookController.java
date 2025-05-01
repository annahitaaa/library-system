package com.example.library_system.controller;

import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;
import com.example.library_system.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public void create(@Valid @RequestBody BookDto bookDto) {
        bookService.create(bookDto);
    }

    @PutMapping
    public void update(@Valid @RequestBody BookDto bookDto) {
        bookService.update(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }

    @GetMapping("/{bookId}/available")
    public ResponseEntity<Boolean> isBookAvailable(@PathVariable Long bookId) {

        return new ResponseEntity<>(bookService.isBookAvailable(bookId), HttpStatus.OK);
    }


}
