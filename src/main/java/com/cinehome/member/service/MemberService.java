package com.cinehome.member.service;

import com.cinehome.member.domain.MemberDomain;

public interface MemberService {
    MemberDomain findId(String memberId, String memberPw) throws Exception;
    public MemberDomain signUp(MemberDomain member) throws Exception;
}
