package com.example.library_system.mapper;

import com.example.library_system.model.Borrowing;
import com.example.library_system.model.dto.BorrowingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, BorrowerMapper.class})
public interface BorrowingMapper {
    Borrowing toEntity(BorrowingDto borrowingDto);

    @Mapping(source = "book", target = "bookDto")
    @Mapping(source = "borrower", target = "borrowerDto")
    BorrowingDto toDto(Borrowing borrowing);

    List<BorrowingDto> toDtoList(List<Borrowing> borrowings);
}
