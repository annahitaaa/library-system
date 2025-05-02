package com.example.library_system.controller;

import com.example.library_system.model.dto.BorrowingDto;
import com.example.library_system.service.BorrowingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class BorrowingController {
    private final BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<BorrowingDto>> getAllBorrowings() {
        return ResponseEntity.ok(borrowingService.findAll());
    }

    @PostMapping("/borrowing")
    public ResponseEntity<?> borrow(@RequestParam Long bookId, @RequestParam Long borrowerId) {

        try {
            BorrowingDto borrowingDto = borrowingService.borrowBook(bookId, borrowerId);
            return ResponseEntity.ok().body(borrowingDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/returning")
    public void returnBook(@RequestParam Long bookId) {
        borrowingService.returnBook(bookId);
    }




}
