package com.example.library_system.service.impl;

import com.example.library_system.mapper.BorrowerMapper;
import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import com.example.library_system.repository.BorrowerRepository;
import com.example.library_system.service.BorrowerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    private final BorrowerRepository borrowerRepository;
    private final BorrowerMapper borrowerMapper;
    @Override
    public void create(BorrowerDto borrowerDto) {
        borrowerRepository.save(borrowerMapper.toEntity(borrowerDto));
    }

    @Override
    public void update(BorrowerDto borrowerDto) {
        borrowerRepository.save(borrowerMapper.toEntity(borrowerDto));
    }

    @Override
    public void delete(Long borrowerId) {
        borrowerRepository.deleteById(borrowerId);
    }

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower findById(Long borrowerId) {
        return borrowerRepository.findById(borrowerId).orElseThrow(()-> new RuntimeException("Borrower not found"));
    }
}
