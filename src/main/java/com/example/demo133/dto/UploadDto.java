package com.example.demo133.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class UploadDto {
    private int f_no;
    private int idx;
    private String oname;
    private String sname;
    private String path;
    private String file_type;
    private String regdate;

    public void setSnameValue(String oName) {
        int index = oName.lastIndexOf(".");
        String fileName = oName.substring(0, index);
        String fileExtension = oName.substring(index);
        String uuid = UUID.randomUUID().toString();
        sname = fileName + "_" + uuid + fileExtension;
    }

}
