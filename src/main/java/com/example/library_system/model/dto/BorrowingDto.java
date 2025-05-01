package com.example.library_system.model.dto;

import com.example.library_system.model.BorrowingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BorrowingDto {
    private BookDto bookDto;
    private BorrowerDto borrowerDto;
    private Date startDate;
    private Date dueDate;
    private Date returnDate;
    private BorrowingStatus status;
}
