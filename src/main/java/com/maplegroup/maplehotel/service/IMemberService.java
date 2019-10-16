package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Member;

import java.util.List;

public interface IMemberService {

    //添加会员
    public boolean addMember(Member member);

    //删除会员
    public boolean deleteMember(String memberName);

    //修改会员
    public boolean updateByIdentifier(String memberIdentifier);

    //查询会员
    Member findMemberByIdentifier(String memberIdentifier);
    Member findMemberByName(String memberName);
    Member findMemberByPhoneNumber(String memberPhoneNumber);
    List<Member> findMemberAll();


}
