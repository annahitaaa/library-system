package com.example.library_system.service.impl;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import com.example.library_system.service.BorrowerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    @Override
    public void create(BorrowerDto borrowerDto) {

    }

    @Override
    public void update(BorrowerDto borrowerDto) {

    }

    @Override
    public void delete(Long borrowerId) {

    }

    @Override
    public List<Borrower> findAll() {
        return List.of();
    }
}
