package com.example.demo133.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo133.dto.BookDto;
import com.example.demo133.dto.SearchDto;
import com.example.demo133.dto.UploadDto;
import com.example.demo133.service.BookService;
import com.example.demo133.service.UploadService;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BookController {
    @Autowired
    BookService service;

    @Autowired
    UploadService uploadService;

    @GetMapping("/book/bookList")
    public String list(
            SearchDto searchDto, Model model) {
        Map<String, Object> map = service.selectBookList(searchDto);
        model.addAttribute("map", map);

        return "/book/list";
    }

    @GetMapping("/book/bookInsert")
    public String getMethodName() {
        return "/book/insert";
    }

    @PostMapping("/book/bookInsertAction")
    public String insertAction(
            @RequestPart(name = "file", required = false) List<MultipartFile> files, BookDto book, Model model) {
        if (files != null && files.size() > 0) {
            if (!"".equals(files.get(0).getOriginalFilename())) {
                int f_no = uploadService.insertUploadMulti(files, "book");
                book.setImg_f_no(f_no);
            }
        }

        int res = service.insertBook(book);
        if (res > 0) {
            return "redirect:/book/bookList";
        } else {
            model.addAttribute("msg", "도서등록 중 문제가 발생하였습니다.\n관리자에게 문의하세요.");
            return "/common/msg";
        }
    }

    @GetMapping("/book/bookDetail")
    public String detail(
            BookDto book, Model model) {
        BookDto selectBook = service.selectBookDetail(book);
        model.addAttribute("book", selectBook);

        List<UploadDto> imgFileList = uploadService.selectUploadList(selectBook.getImg_f_no());
        model.addAttribute("imgFileList", imgFileList);
        return "/book/detail";
    }
}
