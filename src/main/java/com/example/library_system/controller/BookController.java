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
    public ResponseEntity<List<BookDto.Info>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto.Info> getBookById(@PathVariable long bookId) {
        return ResponseEntity.ok(bookService.findById(bookId));
    }

    @PostMapping
    public ResponseEntity<BookDto.Info> create(@Valid @RequestBody BookDto bookDto) {

        return ResponseEntity.ok(bookService.create(bookDto));
    }

    @PutMapping
    public ResponseEntity<BookDto.Info> update(@Valid @RequestBody BookDto.Info bookDtoInfo) {
       return ResponseEntity.ok(bookService.update(bookDtoInfo));
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable Long bookId) {
        bookService.deleteById(bookId);
    }

    @GetMapping("/{bookId}/available")
    public ResponseEntity<Boolean> isBookAvailable(@PathVariable Long bookId) {

        return ResponseEntity.ok(bookService.isBookAvailable(bookId));
    }


}
