package com.example.library_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private BorrowingStatus status;
}
