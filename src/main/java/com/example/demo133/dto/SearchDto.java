package com.example.demo133.dto;

import lombok.Data;

@Data
public class SearchDto {
    private int pageNo = 1;
    private int amount = 5;

    private String searchField;
    private String searchWord;
}
