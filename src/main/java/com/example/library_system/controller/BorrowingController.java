package com.example.library_system.controller;

import com.example.library_system.model.Borrowing;
import com.example.library_system.model.dto.BorrowingDto;
import com.example.library_system.service.BorrowingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowing")
@AllArgsConstructor
public class BorrowingController {
    private BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<Borrowing>> getAllBorrowing() {
        return new ResponseEntity<>(borrowingService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{borrowingId}")
    public ResponseEntity<Borrowing> getBorrowingById(@RequestParam Long borrowingId) {
        return new ResponseEntity<>(borrowingService.findById(borrowingId), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.create(borrowingDto);
    }

    @PutMapping
    public void update(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.update(borrowingDto);
    }

    @DeleteMapping("{borrowingId}")
    public void delete(@PathVariable Long borrowingId) {
        borrowingService.delete(borrowingId);
    }
}
