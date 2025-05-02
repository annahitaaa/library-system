package com.example.library_system.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    private Boolean isAvailable;
    //private Date borrowingDueDate;

    @Getter
    @Setter
    public static class Info extends BookDto {
        @NotNull
        private Long bookId;
    }
}
