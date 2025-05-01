package com.example.library_system.mapper;

import com.example.library_system.model.Book;
import com.example.library_system.model.dto.BookDto;
import com.example.library_system.service.BookService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
   // @Mapping(target = "isAvailable", expression = "java(bookService.isBookAvailable(book.getId()))")
    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);

}
