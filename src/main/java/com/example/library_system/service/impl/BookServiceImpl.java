package com.example.library_system.service.impl;

import com.example.library_system.mapper.BookMapper;
import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;
import com.example.library_system.repository.BookRepository;
import com.example.library_system.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookDto.Info create(BookDto bookDto) {
        return bookMapper.toInfoDto(bookRepository.save(bookMapper.toEntity(bookDto)));
    }

    @Override
    @Transactional
    public BookDto.Info update(BookDto.Info bookDTOInfo) {
        return bookMapper.toInfoDto(bookRepository.save(bookMapper.InfoDtoToEntity(bookDTOInfo)));
    }

    @Override
    @Transactional
    public void deleteById(Long bookId) throws Exception {
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
        if (book.getBorrowings() !=null && !book.getBorrowings().isEmpty()) {
            throw new Exception("there is dependency record");
        }
        bookRepository.deleteById(bookId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<BookDto.Info> findAll() {
        return bookMapper.toInfoDtoList(bookRepository.findAll());
    }

    @Override
    public BookDto.Info findById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return bookMapper.toInfoDto(optionalBook.orElseThrow(()-> new RuntimeException("Book not found")));
    }

    @Override
    public Book findEntityById(Long bookId) {
       return bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    @Override
    public boolean isBookAvailable(Long bookId) {
        return findById(bookId).getIsAvailable();
    }
}
