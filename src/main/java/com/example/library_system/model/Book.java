package com.example.library_system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String author;

}
