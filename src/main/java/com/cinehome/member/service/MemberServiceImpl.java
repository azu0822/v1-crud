package com.cinehome.member.service;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    MemberDomain memberDomain;

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
}
