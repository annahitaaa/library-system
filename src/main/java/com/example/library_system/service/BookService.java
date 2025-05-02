package com.example.library_system.service;


import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto.Info create(BookDto bookDTO);
    BookDto.Info update(BookDto.Info bookDTOInfo);
    void deleteById(Long bookId) throws Exception;
    List<BookDto.Info> findAll();
    BookDto.Info findById(Long bookId);
    Book findEntityById(Long bookId);
    boolean isBookAvailable(Long bookId);

}
