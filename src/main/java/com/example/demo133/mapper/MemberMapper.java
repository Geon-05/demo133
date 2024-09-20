package com.example.demo133.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo133.dto.MemberDto;
import com.example.demo133.dto.SearchDto;

@Mapper
public interface MemberMapper {
    public List<MemberDto> selectMemberList(SearchDto searchDto);

    public int selectTotalCnt(SearchDto searchDto);

    public int insertTestMember();

    public MemberDto selectMemberDetail(MemberDto member);
}
