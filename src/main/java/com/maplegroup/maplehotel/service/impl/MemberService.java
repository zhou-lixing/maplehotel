package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IMemberDao;
import com.maplegroup.maplehotel.entity.Member;
import com.maplegroup.maplehotel.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService implements IMemberService {

    @Autowired
    private IMemberDao memberDao;

    @Override
    public boolean addMember(Member member) {
        String str = memberDao.findMaxIdentifier();
        String memberIdentifier = (Integer.parseInt(str)+1)+"";
        member.setMemberIdentifier(memberIdentifier);
        if (memberDao.addMember(member)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMember(String memberName) {
        if (memberDao.deleteMember(memberName)>0){
            return true;
        }

       return false;
    }

    @Override
    public boolean updateByIdentifier(String memberIdentifier) {
        if (memberDao.updateByIdentifier(memberIdentifier)>0){
            return true;
        }

        return false;
    }

    @Override
    public Member findMemberByIdentifier(String memberIdentifier) {
        Member member = memberDao.findMemberByIdentifier(memberIdentifier);
        return member;
    }


    @Override
    public Member findMemberByName(String memberName) {
        Member member = memberDao.findMemberByName(memberName);
        return member;
    }

    @Override
    public Member findMemberByPhoneNumber(String memberPhoneNumber) {
        Member member = memberDao.findMemberByPhoneNumber(memberPhoneNumber);
        return member;
    }

    @Override
    public List<Member> findMemberAll() {
        List<Member> memberList = memberDao.findMemberAll();
        return memberList;
    }
}
