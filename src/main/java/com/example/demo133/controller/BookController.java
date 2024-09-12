package com.example.demo133.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo133.dto.SearchDto;
import com.example.demo133.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
    @Autowired
    BookService service;
    
    @GetMapping("/book/bookList")
    public String list(
        SearchDto searchDto
        , Model model
        ) {
            Map<String, Object> map = service.selectBookList(searchDto);
            model.addAttribute("map", map);

        return "/book/list";
    }
    
    @GetMapping("/test/test")
    public String getMethodName() {
        return "/test/list";
    }
    
}
