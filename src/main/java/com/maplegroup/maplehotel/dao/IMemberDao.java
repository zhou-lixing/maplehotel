package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Member;

import java.util.List;

public interface IMemberDao {
    //根据编号查询会员
    Member findMemberByIdentifier(String memberIdentifier);
    //根据姓名查询会员
    Member findMemberByName(String memberName);
    //根据手机号查询会员
    Member findMemberByPhoneNumber(String memberPhoneNumber);
    //添加会员
    int addMember(Member member);
    //删除会员
    int deleteMember(String memberName);
    //查询所有会员
    List<Member> findMemberAll();
    //修改会员
    int updateByIdentifier(String memberIdentifier);

    int updateFinalBookingTime(String memberName);
    int updateLastCheckInTime(String memberName);

    String findMaxIdentifier();
}
