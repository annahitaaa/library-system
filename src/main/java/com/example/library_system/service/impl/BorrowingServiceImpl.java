package com.example.library_system.service.impl;

import com.example.library_system.model.Borrowing;
import com.example.library_system.model.dto.BorrowingDto;
import com.example.library_system.service.BorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    @Override
    public void create(BorrowingDto borrowingDto) {

    }

    @Override
    public void update(BorrowingDto borrowingDto) {

    }

    @Override
    public void delete(Long borrowingId) {

    }

    @Override
    public List<Borrowing> findAll() {
        return List.of();
    }
}
