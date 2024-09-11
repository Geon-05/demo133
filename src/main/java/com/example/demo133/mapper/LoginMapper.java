package com.example.demo133.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo133.dto.MemberDto;

@Mapper
public interface LoginMapper {
    public MemberDto login(MemberDto member);

    public int selectCheckId(String id);
}
