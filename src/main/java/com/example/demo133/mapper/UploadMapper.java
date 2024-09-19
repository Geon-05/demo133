package com.example.demo133.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo133.dto.UploadDto;

@Mapper
public interface UploadMapper {

    public int selectSeqUploadFile();

    public int insertUploadMulti(UploadDto uploadDto);
  
    public List<UploadDto> selectUpload(int f_no);
}
