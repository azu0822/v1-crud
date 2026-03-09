package com.cinehome.member.service;

import com.cinehome.member.domain.MemberDomain;
import com.cinehome.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

//    @Override
//    public MemberDomain login(String memberId, String memberPw) throws Exception {
//        MemberMapper member = memberMapper.login(memberId, memberPw);
//        return member;
//    }
}
