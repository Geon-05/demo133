package com.example.demo133.dto;

import lombok.Data;

@Data
public class PageDto {
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private SearchDto searchDto;
    private int totalCnt;

    public PageDto(SearchDto searchDto, int totalCnt){
        this.searchDto = searchDto;

        int pageBlockAmount = 5;
        int realEndPage;

        endPage = (int) Math.ceil(searchDto.getPageNo() * 1.0 / pageBlockAmount) * pageBlockAmount;
        startPage = endPage - (pageBlockAmount - 1);

        if (totalCnt == 0) {
            realEndPage = 1;
        } else {
            realEndPage = (int) Math.ceil(totalCnt * 1.0 / searchDto.getAmount());
        }

        if (endPage > realEndPage){
            endPage = realEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = realEndPage > endPage ? true : false;
    }
}
