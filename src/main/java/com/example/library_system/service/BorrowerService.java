package com.example.library_system.service;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;

import java.util.List;

public interface BorrowerService {
    void create(BorrowerDto borrowerDto);
    void update(BorrowerDto borrowerDto);
    void delete(Long borrowerId);
    List<Borrower> findAll();
}
