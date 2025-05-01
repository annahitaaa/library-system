package com.example.library_system.mapper;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowerMapper {
    @Mapping(target = "active", ignore = true)
    Borrower toEntity(BorrowerDto borrowerDto);

    BorrowerDto toDto(Borrower borrower);
}
