package com.example.library_system.service.impl;

import com.example.library_system.mapper.BorrowerMapper;
import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import com.example.library_system.repository.BorrowerRepository;
import com.example.library_system.service.BorrowerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    private final BorrowerRepository borrowerRepository;
    private final BorrowerMapper borrowerMapper;

    @Override
    @Transactional
    public BorrowerDto.Info create(BorrowerDto borrowerDto) {
        return borrowerMapper.toDtoInfo(borrowerRepository.save(borrowerMapper.toEntity(borrowerDto)));
    }

    @Override
    @Transactional
    public BorrowerDto.Info update(BorrowerDto.Info borrowerDtoInfo) {
        return borrowerMapper.toDtoInfo(borrowerRepository.save(borrowerMapper.toEntity(borrowerDtoInfo)));
    }

    @Override
    @Transactional
    public void delete(Long borrowerId) throws Exception {
        Borrower borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new RuntimeException("Borrower not found"));
        if(borrower.getBorrowings() != null && !borrower.getBorrowings().isEmpty()) {
            throw new Exception("there is dependency record");
        }
        borrowerRepository.deleteById(borrowerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BorrowerDto.Info> findAll() {
        return borrowerMapper.toDtoInfoList(borrowerRepository.findAll());
    }

    @Override
    public BorrowerDto.Info findById(Long borrowerId) {
        Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowerId);
        return borrowerMapper.toDtoInfo(optionalBorrower.orElseThrow(()-> new RuntimeException("Borrower not found")));
    }

    @Override
    public Borrower findEntityById(Long borrowerId) {
        return borrowerRepository.findById(borrowerId).orElseThrow(()-> new RuntimeException("Borrower not found"));
    }
}
