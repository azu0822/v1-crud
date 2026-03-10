package com.cinehome.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor // 기본생성자
@ToString //디버깅
public class MemberDomain {
    private int userId;            // 사용자 식별ID
    private String memberId;       // 로그인 아이디
    private String memberPw;       // 로그인 패스워드
    private String name;           // 성명
    private String phone;          // 휴대폰번호
    private String role;           // 일반유저/관리자 식별용
    private LocalDateTime re_dt;   // 생성일자
}