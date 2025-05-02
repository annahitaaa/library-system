package com.example.library_system.repository;

import com.example.library_system.model.Book;
import com.example.library_system.model.Borrower;
import com.example.library_system.model.Borrowing;
import com.example.library_system.model.BorrowingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    //List<Borrowing> findByBorrowerIdAndStatus(Long borrowerId, BorrowingStatus status);
    long countByBorrower_BorrowerIdAndStatus(Long borrowerId, BorrowingStatus status);

    //@Query("SELECT b FROM Borrowing b WHERE b.borrower = ?1 AND b.dueDate < CURRENT_DATE AND b.returnDate IS NULL")
   // List<Borrowing> findLateBorrowingsByBorrower(Borrower borrower);

   // @Query("SELECT COUNT(b) FROM Borrowing b WHERE b.borrower = ?1 AND b.dueDate < CURRENT_DATE AND b.returnDate IS NULL")
   // long countLateBorrowingsByBorrower(Borrower borrower);

   // @Query("SELECT b FROM Borrowing b WHERE b.book = ?1 AND b.returnDate IS NULL")
   // List<Borrowing> findActiveBorrowingByBook(Book book);
    Borrowing findByBook_BookIdAndStatus(Long bookId,BorrowingStatus status);
}
