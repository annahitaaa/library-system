package com.example.library_system.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowerDto {
    @NotEmpty
    private String name;
    private Boolean active;

    @Getter
    @Setter
    public static class Info extends BorrowerDto {
        @NotNull
        private Long borrowerId;
    }

}
