package com.example.library_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowerId;

    @NotEmpty
    private String name;
    private Boolean active = true;

    @OneToMany(mappedBy = "borrower")
    @JsonIgnore
    private List<Borrowing> borrowings;
}
