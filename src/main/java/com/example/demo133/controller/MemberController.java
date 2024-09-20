package com.example.demo133.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo133.dto.MemberDto;
import com.example.demo133.dto.SearchDto;
import com.example.demo133.dto.UploadDto;
import com.example.demo133.service.MemberService;
import com.example.demo133.service.UploadService;

@Controller
public class MemberController {
    @Autowired
    MemberService service;

    @Autowired
    UploadService uploadService;

    @GetMapping("/member/memberList")
    public String list(SearchDto searchDto, Model model) {
        Map<String, Object> map = service.selectMemberList(searchDto);
        model.addAttribute("map", map);

        return "/member/list";
    }

    @GetMapping("/member/testMemberInsert")
    public String insertTestMember(Model model) {
        int res = service.insertTestMember();
        if (res > 0) {
            return "redirect:/member/memberList";
        } else {
            model.addAttribute("msg", "테스트 사용자 등록 중 문제가 발생하였습니다.\n관리자에게 문의하세요.");
            return "/common/msg";
        }
    }

    @GetMapping("/member/memberDetail")
    public String detail(MemberDto member, Model model) {
        MemberDto selectMember = service.selectMemberDetail(member);
        model.addAttribute("member", selectMember);

        List<UploadDto> imgFileList = uploadService.selectUploadList(selectMember.getImg_f_no());
        model.addAttribute("imgFileList", imgFileList);

        return "/member/detail";
    }

    @GetMapping("/member/memberUpdate")
    public String update(
            MemberDto member, Model model) {
        MemberDto selectMember = service.selectMemberDetail(member);
        model.addAttribute("member", selectMember);
        return "/member/update";
    }

    @PostMapping("/member/memberUpdateAction")
    public String updateAction(
            MemberDto member, Model model) {
        int res = service.updateMember(member);
        if (res > 0) {
            return "redirect:/member/memberList";
        } else {
            model.addAttribute("msg", "도서수정 중 문제가 발생하였습니다.\n관리자에게 문의하세요.");
            return "/common/msg";
        }
    }

    @GetMapping("/member/memberDelete")
    public String delete(
            @RequestParam(name = "mem_no", required = false) String memberNo, Model model) {
        if (memberNo == null) {
            model.addAttribute("msg", "사용자번호가 입력되지 않았습니다.");
            return "/common/msg";
        }

        int res = service.deleteMember(memberNo);

        if (res > 0) {
            model.addAttribute("msg", "삭제 되었습니다.");
            model.addAttribute("url", "/member/memberList");
        } else {
            model.addAttribute("msg", "삭제 중 예외가 발생 하였습니다.\n관리자에게 문의해주세요");
        }
        return "/common/msg";
    }
}
