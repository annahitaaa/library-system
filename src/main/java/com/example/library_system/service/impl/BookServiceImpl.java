package com.example.library_system.service.impl;

import com.example.library_system.mapper.BookMapper;
import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;
import com.example.library_system.repository.BookRepository;
import com.example.library_system.service.BookService;
import com.example.library_system.service.BorrowingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BorrowingService borrowingService;

    @Override
    @Transactional
    public void create(BookDto bookDto) {
        bookRepository.save(bookMapper.toEntity(bookDto));
    }

    @Override
    @Transactional
    public void update(BookDto bookDTO) {
        bookRepository.save(bookMapper.toEntity(bookDTO));
    }

    @Override
    @Transactional
    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    @Override
    public boolean isBookAvailable(Long bookId) {
        //Todo
        findById(bookId);
        return false;
    }
}
