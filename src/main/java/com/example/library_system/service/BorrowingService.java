package com.example.library_system.service;

import com.example.library_system.model.Borrowing;
import com.example.library_system.model.dto.BorrowingDto;

import java.util.List;

public interface BorrowingService {
    void create(BorrowingDto borrowingDto);
    void update(BorrowingDto borrowingDto);
    void delete(Long borrowingId);
    List<Borrowing> findAll();
    Borrowing findById(Long BorrowingId);
}
