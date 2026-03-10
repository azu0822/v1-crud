package com.cinehome.member.service;

import com.cinehome.member.domain.MemberDomain;
import org.springframework.stereotype.Service;

public interface MemberService {
    MemberDomain findId(String memberId, String memberPw) throws Exception;
}
