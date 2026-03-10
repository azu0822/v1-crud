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

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/signUpForm")
    public String sighUp() {
        return "member/signUpForm";
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
            return "redirect:/";

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

    // 회원가입 시
    @PostMapping("/signUp")
    public String loginCheck(@RequestParam("memberId") String memberId,
                             @RequestParam("memberPw") String memberPw,
                             @RequestParam("confirmPw") String confirmPw,
                             @RequestParam("name") String name, @RequestParam("phone") String phone,
                             Model model) throws Exception {   //html
        try {
            // memberId 입력됐는지, memberPw와 confirmPw가 다르면 에러
            if (memberId == null || memberId.isEmpty() || memberPw == null || !memberPw.equals(confirmPw)) {
                model.addAttribute("error", "비밀번호가 다릅니다.");
                return "member/signUpForm";
            }
            MemberDomain member = new MemberDomain();
            member.setMemberId(memberId); member.setMemberPw(memberPw);member.setName(name); member.setPhone(phone);

            // 회원ID가 존재하는지 확인하고 존재하면 회원 저장
            MemberDomain memberResult = memberService.signUp(member);

            // null 값이 반환되었으면 에러 메시지
            if(memberResult == null){
                model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "member/signUpForm";
            }
            // 성공적으로 저장되었으면 홈으로
            return "redirect:/";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Exception 에러 발생");
            model.addAttribute("error", "서버 에러: " + e.getMessage());
            return "member/signUpForm";
        }
    }
}