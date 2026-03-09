package com.cinehome.member.controller;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;
    MemberDomain memberDomain;

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }
    @PostMapping("/login")
    public String loginCheck(@RequestParam("memberId") String memberId,
                             @RequestParam("memberPw") String memberPw,
                             Model model) throws Exception {    //html
        //확인하는 쿼리
//        MemberDomain member = memberService.login(memberId, memberPw);

        //확인되어 성공시
     return "redirect:/board";
    }


}
