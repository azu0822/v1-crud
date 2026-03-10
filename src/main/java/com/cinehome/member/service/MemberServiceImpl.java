package com.cinehome.member.service;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    // 로그인
    @Override
    public MemberDomain findId(String memberId, String memberPw) throws Exception {
        // DB 확인
        MemberDomain member = memberMapper.findId(memberId);
        // 값을 로그인페이지에서 입력한것과 비교
        if(member != null && member.getMemberPw().equals(memberPw)) {
            return member;
        }
        return null;
    }

    // 회원가입
//    @Override
//    public MemberDomain signUp(MemberDomain member) throws Exception {
//        // DB 확인
//        MemberDomain existMember = memberMapper.findId(member.getMemberId());
//        // DB에 아이디가 있으면 '이미 사용중인 아이디입니다.'반환
//        if(existMember != null || !existMember.getMemberId().isEmpty()){
//            throw new IllegalStateException("이미 사용중인 아이디입니다.");
//        }
//        // 아이디가 존재하지 않으면 회원 저장
//        memberMapper.signUp(member);
//    }
//}

    // 회원가입
    @Override
    public MemberDomain signUp(MemberDomain member) throws Exception {
        // DB 확인
        MemberDomain existMember = memberMapper.findId(member.getMemberId());
        // 회원ID가 존재하지 않으면 회원 저장
        if (existMember == null || existMember.getMemberId().isEmpty()) {
            memberMapper.signUp(member);
            return member;
        } else {
            // 아이디가 존재하면 null값 반환해서 에러 처리
            return null;
        }
    }
}
