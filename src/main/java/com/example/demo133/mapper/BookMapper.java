package com.example.demo133.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo133.dto.BookDto;
import com.example.demo133.dto.SearchDto;

@Mapper
public interface BookMapper {
    public List<BookDto> selectBookList(SearchDto searchDto);
    
    public int selectTotalCnt(SearchDto searchDto);
    
    public int insertBook(BookDto book);

    public BookDto selectBookDetail(BookDto book);

    public int updateBook(BookDto book);

    public int deleteBook(String book_no);
}
