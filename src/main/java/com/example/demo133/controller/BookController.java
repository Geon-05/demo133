package com.example.demo133.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/book/bookUpdate")
    public String update(
            BookDto book, Model model) {
        BookDto selectBook = service.selectBookDetail(book);
        model.addAttribute("book", selectBook);
        return "/book/update";
    }

    @PostMapping("/book/bookUpdateAction")
    public String updateAction(
            BookDto book, Model model) {
        int res = service.updateBook(book);
        if (res > 0) {
            return "redirect:/book/bookList";
        } else {
            model.addAttribute("msg", "도서수정 중 문제가 발생하였습니다.\n관리자에게 문의하세요.");
            return "/common/msg";
        }
    }

    @GetMapping("/book/bookDelete")
    public String delete(
            @RequestParam(name = "book_no", required = false) String bookNo, Model model) {
        if (bookNo == null) {
            model.addAttribute("msg", "도서번호가 입력되지 않았습니다.");
            return "/common/msg";
        }

        int res = service.deleteBook(bookNo);

        if (res > 0) {
            model.addAttribute("msg", "삭제 되었습니다.");
            model.addAttribute("url", "/book/bookList");
        } else {
            model.addAttribute("msg", "삭제 중 예외가 발생 하였습니다.\n관리자에게 문의해주세요");
        }
        return "/common/msg";
    }
}
