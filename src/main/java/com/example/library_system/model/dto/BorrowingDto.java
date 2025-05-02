package com.example.library_system.model.dto;

import com.example.library_system.model.BorrowingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class BorrowingDto {
    private BookDto bookDto;
    private BorrowerDto borrowerDto;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private BorrowingStatus status;
}
