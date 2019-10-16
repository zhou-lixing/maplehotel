package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.ICheckInRegistDao;
import com.maplegroup.maplehotel.dao.IMemberDao;
import com.maplegroup.maplehotel.entity.CheckInInfo;
import com.maplegroup.maplehotel.entity.Member;
import com.maplegroup.maplehotel.service.ICheckInRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CheckInRegistService implements ICheckInRegistService {

    @Autowired
    private ICheckInRegistDao checkInRegistDao;

    @Autowired
    private IMemberDao memberDao;

    @Override
    public boolean addCheckIn(CheckInInfo checkInInfo,Member member) {
        if(memberDao.findMemberByName(member.getMemberName())==null){

            memberDao.addMember(member);

        }
        checkInRegistDao.addCheckIn(checkInInfo);

        return true;
    }

    @Override
    public boolean delCheckIn(String checkInInfoHomeNum) {

        checkInRegistDao.delCheckIn(checkInInfoHomeNum);

        return true;
    }

    @Override
    public boolean updateCheckIn(String checkInInfoHomeNum) {

        checkInRegistDao.updateCheckIn(checkInInfoHomeNum);

        return true;
    }

    @Override
    public String findMaxIdOfCheckInNum() {
        return checkInRegistDao.findMaxIdOfCheckInNum();
    }

    @Override
    public CheckInInfo findCheckInByHomeNumber(String checkInInfoHomeNum) {
        CheckInInfo checkInInfo = checkInRegistDao.findCheckInByHomeNumber(checkInInfoHomeNum);
        return checkInInfo;
    }

    @Override
    public CheckInInfo findCheckInByHuman(String checkInInfoHuman) {
        CheckInInfo checkInInfo = checkInRegistDao.findCheckInByHuman(checkInInfoHuman);
        return checkInInfo;
    }

    @Override
    public List<CheckInInfo> findCheckInByType(String checkInInfoRoomType) {
        List<CheckInInfo> checkInInfos = checkInRegistDao.findCheckInByType(checkInInfoRoomType);
        return checkInInfos;
    }

    @Override
    public List<CheckInInfo> findAllCheckIn() {
        List<CheckInInfo> checkInInfoAll = checkInRegistDao.findAllCheckIn();
        return checkInInfoAll;
    }

    @Override
    public List<CheckInInfo> find(Map<String, String> map) {
        return checkInRegistDao.find(map);
    }
}
