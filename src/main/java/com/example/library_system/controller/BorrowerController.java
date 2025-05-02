package com.example.library_system.controller;

import com.example.library_system.model.dto.BorrowerDto;
import com.example.library_system.service.BorrowerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<List<BorrowerDto.Info>> getAllBorrowers() {
        return ResponseEntity.ok(borrowerService.findAll());
    }

    @GetMapping("/{borrowerId}")
    public ResponseEntity<BorrowerDto.Info> getBorrowerById(@PathVariable Long borrowerId) {
        return ResponseEntity.ok(borrowerService.findById(borrowerId));
    }

    @PostMapping
    public ResponseEntity<BorrowerDto.Info> create(@Valid @RequestBody BorrowerDto borrowerDto) {
        return ResponseEntity.ok(borrowerService.create(borrowerDto));
    }

    @PutMapping
    public ResponseEntity<BorrowerDto.Info> update(@Valid @RequestBody BorrowerDto.Info borrowerDtoInfo) {
        return ResponseEntity.ok(borrowerService.update(borrowerDtoInfo));
    }

    @DeleteMapping("/{borrowerId}")
    public ResponseEntity<String> delete(@PathVariable Long borrowerId) {
        try {
            borrowerService.delete(borrowerId);
            return ResponseEntity.ok("Borrower deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
