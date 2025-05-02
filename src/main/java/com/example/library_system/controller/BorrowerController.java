package com.example.library_system.controller;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import com.example.library_system.service.BorrowerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.LongSummaryStatistics;

@RestController
@AllArgsConstructor
@RequestMapping("/api/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<List<Borrower>> getAllBorrowers() {
        return new ResponseEntity<>(borrowerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{borrowerId}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable Long borrowerId) {
        return new ResponseEntity<>(borrowerService.findById(borrowerId), HttpStatus.OK);
    }

    @PostMapping
    public void create(@Valid @RequestBody BorrowerDto borrowerDto) {
        borrowerService.create(borrowerDto);
    }

    @PutMapping
    public void update(@Valid @RequestBody BorrowerDto borrowerDto) {
        borrowerService.update(borrowerDto);
    }

    @DeleteMapping("/{boroowerId}")
    public void delete(@PathVariable Long borrowerId) {
        borrowerService.delete(borrowerId);
    }


}
