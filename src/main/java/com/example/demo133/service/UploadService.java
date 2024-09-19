package com.example.demo133.service;

import java.io.File;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo133.dto.UploadDto;
import com.example.demo133.mapper.UploadMapper;

@Service
public class UploadService {
    @Autowired
    UploadMapper mapper;

    public int insertUploadMulti(
            List<MultipartFile> uploadFiles, String path) {
        int f_no = mapper.selectSeqUploadFile();

        for (int i = 0; i < uploadFiles.size(); i++) {
            MultipartFile file = uploadFiles.get(i);
            UploadDto uploadDto = makeUploadDto(file, path, i, f_no);

            try {
                File uploadFile = new File("d:/upload/" + path + File.separator + uploadDto.getSname());
                file.transferTo(uploadFile);
                mapper.insertUploadMulti(uploadDto);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f_no;
    }

    public UploadDto makeUploadDto(
            MultipartFile file, String path, int idx, int f_no) {
        UploadDto uploadDto = new UploadDto();

        uploadDto.setOname(file.getOriginalFilename());
        uploadDto.setSnameValue(file.getOriginalFilename());
        uploadDto.setPath(path);
        uploadDto.setIdx(idx + 1);
        uploadDto.setFile_type(file.getContentType());
        uploadDto.setF_no(f_no);

        String dir = "d:/upload/" + path + File.separator;
        makeDir(dir);

        return uploadDto;
    }

    public void makeDir(String dir) {
        File uploadDir = new File(dir);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public List<UploadDto> selectUploadList(int img_f_no) {
        return mapper.selectUpload(img_f_no);
    }
}
