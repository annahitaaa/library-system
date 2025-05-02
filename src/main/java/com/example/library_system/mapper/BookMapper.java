package com.example.library_system.mapper;

import com.example.library_system.model.Book;
import com.example.library_system.model.BorrowingStatus;
import com.example.library_system.model.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "isAvailable",source = ".", qualifiedByName = "isAvailable")
    BookDto toDto(Book book);

    @Mapping(target = "isAvailable",source = ".", qualifiedByName = "isAvailable")
    BookDto.Info toInfoDto(Book book);
    List<BookDto.Info> toInfoDtoList(List<Book> books);

    Book toEntity(BookDto bookDto);
    Book InfoDtoToEntity(BookDto.Info bookDtoInfo);

    @Named("isAvailable")
    default Boolean isAvailable(Book book) {
        if (book.getBorrowings() == null || book.getBorrowings().isEmpty()) {
            return true;
        }
        return book.getBorrowings().stream().noneMatch(item -> item.getStatus() == BorrowingStatus.BORROWED);
    }

}
