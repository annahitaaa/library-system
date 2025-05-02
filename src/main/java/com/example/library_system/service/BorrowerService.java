package com.example.library_system.service;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BorrowerService {
    BorrowerDto.Info create(BorrowerDto borrowerDto);
    BorrowerDto.Info update(BorrowerDto.Info borrowerDtoInfo);
    void delete(Long borrowerId);
    List<BorrowerDto.Info> findAll();
    BorrowerDto.Info findById(Long borrowerId);

    Borrower findEntityById(Long borrowerId);
}
