package com.cinehome.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }
    @PostMapping("login")
    public String loginCheck(String memberId, String memberPw) throws Exception {
        //확인하는 쿼리

        //확인되어 성공시
     return "redirect:/board";
    }


}
