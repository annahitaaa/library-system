package com.example.library_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Borrowing> borrowings;

}
