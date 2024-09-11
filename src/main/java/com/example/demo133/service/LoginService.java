package com.example.demo133.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo133.dto.MemberDto;
import com.example.demo133.mapper.LoginMapper;

@Service
public class LoginService {
    @Autowired
    LoginMapper mapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    public MemberDto login(MemberDto member){
        MemberDto loginMember = mapper.login(member);

        if (encoder.matches(member.getPw(), loginMember.getPw())){
            return loginMember;
        } else {
            return null;
        }
    }
}
