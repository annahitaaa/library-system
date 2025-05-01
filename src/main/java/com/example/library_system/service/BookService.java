package com.example.library_system.service;


import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;

import java.util.List;

public interface BookService {
    void create(BookDto bookDTO);
    void update(BookDto bookDTO);
    void deleteById(Long bookId);
    List<Book> findAll();
    Book findById(Long bookId);
    boolean isBookAvailable(Long bookId);

}
