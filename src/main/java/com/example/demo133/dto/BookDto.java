package com.example.demo133.dto;

import lombok.Data;

@Data
public class BookDto {
    // DB
    private String book_no;
    private String title;
    private String author;
    private int price;
    private String pub_no;
    private String rentyn;
    private String delyn;
    private String regdate;

    private int img_f_no;
    private boolean isNew;
    
}
