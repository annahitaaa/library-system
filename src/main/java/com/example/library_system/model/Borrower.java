package com.example.library_system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowerId;
    private String name;
    private Boolean active;
}
