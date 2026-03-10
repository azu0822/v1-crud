package com.cinehome.member.mapper;

import com.cinehome.member.domain.MemberDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDomain findId(String memberId);
}