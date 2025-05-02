package com.example.library_system.service.impl;

import com.example.library_system.mapper.BorrowingMapper;
import com.example.library_system.model.Borrowing;
import com.example.library_system.model.BorrowingStatus;
import com.example.library_system.model.dto.BorrowingDto;
import com.example.library_system.repository.BorrowingRepository;
import com.example.library_system.service.BookService;
import com.example.library_system.service.BorrowerService;
import com.example.library_system.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    private static final int BORROWING_LIMIT = 5;

    private final BorrowingRepository borrowingRepository;
    private final BookService bookService;
    private final BorrowerService borrowerService;
    private final BorrowingMapper borrowingMapper;



    @Override
    @Transactional
    public BorrowingDto borrowBook(Long bookId, Long borrowerId) {
        if(!bookService.isBookAvailable(bookId)){
            throw new RuntimeException("book is not available");
        }
        if (!checkedBorrowerLimitation(borrowerId)){
            throw new RuntimeException("borrower limit reached");
        }

        return borrowingRegister(bookId, borrowerId);
    }

    @Override
    @Transactional
    public void returnBook(Long bookId) {
        Borrowing borrowing = borrowingRepository.findByBook_BookIdAndStatus(bookId, BorrowingStatus.BORROWED);
        if(borrowing == null){
            throw new RuntimeException("borrowing is not available");
        }
        borrowing.setStatus(BorrowingStatus.RETURNED);
        borrowing.setReturnDate(LocalDate.now());
    }

    @Override
    public List<BorrowingDto> findAll() {
        return borrowingMapper.toDtoList(borrowingRepository.findAll());
    }

    private Boolean checkedBorrowerLimitation(Long borrowerId){
        return borrowingRepository.countByBorrower_BorrowerIdAndStatus(borrowerId, BorrowingStatus.BORROWED) < BORROWING_LIMIT;
    }

    private BorrowingDto borrowingRegister(Long bookId, Long borrowerId) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(bookService.findEntityById(bookId));
        borrowing.setBorrower(borrowerService.findEntityById(borrowerId));
        borrowing.setStatus(BorrowingStatus.BORROWED);
        borrowing.setStartDate(LocalDate.now());
        borrowing.setDueDate(LocalDate.now().plusWeeks(2));
        return borrowingMapper.toDto(borrowingRepository.save(borrowing));
    }

}
