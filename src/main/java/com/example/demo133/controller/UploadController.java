package com.example.demo133.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadController {
    @GetMapping("/download")
    public ResponseEntity<byte[]> getMethodName(
            @RequestParam(name = "fileName") String fileName, @RequestParam(name = "oname") String oname)
            throws IOException {
        File file = new File("d:/upload/" + fileName);

        HttpHeaders headers = new HttpHeaders();

        try {
            if (file.exists()) {
                String mimeType = URLConnection.guessContentTypeFromName(file.getName());
                if (mimeType == null) {
                    mimeType = MediaType.APPLICATION_OCTET_STREAM.toString();
                }
                headers.add("Content-Type", mimeType);
                headers.add("Content-Disposition", "attachment; filename=\""
                        + new String(oname.getBytes("UTF-8"), "ISO-8859-1") + "\"");

                return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (UnsupportedEncodingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
