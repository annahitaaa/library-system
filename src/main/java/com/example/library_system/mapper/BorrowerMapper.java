package com.example.library_system.mapper;

import com.example.library_system.model.Borrower;
import com.example.library_system.model.dto.BorrowerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowerMapper {

    Borrower toEntity(BorrowerDto borrowerDto);

    BorrowerDto toDto(Borrower borrower);
    BorrowerDto.Info toDtoInfo(Borrower borrower);
    List<BorrowerDto.Info> toDtoInfoList(List<Borrower> borrowers);
}
