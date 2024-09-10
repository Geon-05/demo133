package com.example.demo133.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo133.dto.BookDto;
import com.example.demo133.dto.SearchDto;

@Mapper
public interface BookMapper {
    public List<BookDto> selectBookList(SearchDto searchDto);
    
    public int selectTotalCnt(SearchDto searchDto);
}
