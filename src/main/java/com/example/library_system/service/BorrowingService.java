package com.example.library_system.service;


import com.example.library_system.model.dto.BorrowingDto;

import java.util.List;


public interface BorrowingService {
    BorrowingDto borrowBook(Long bookId, Long borrowerId);
    void returnBook(Long bookId);
    List<BorrowingDto> findAll();
}
