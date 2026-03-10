package com.cinehome.member.controller;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
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

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
    // 로그인 입력시
    @PostMapping("/login")
    public String loginCheck(@RequestParam("memberId") String memberId,
                             @RequestParam("memberPw") String memberPw,
                             HttpSession session, Model model) throws Exception {   //html
        try {
            // DB에 확인하는 쿼리
            MemberDomain member = memberService.findId(memberId, memberPw);
            // null값이거나 없으면
            if (member == null) {
                model.addAttribute("Error", "아이디 또는 비밀번호가 틀립니다.");
                return "member/login";
            }
            // 확인되어 성공시 세션에 저장
            session.setAttribute("member", member);
            return "redirect:/review/";

        } catch (Exception e) {
            e.printStackTrace();
            return "member/login";
        }
    }

    // 로그아웃 버튼 클릭시 홈으로
    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
}
