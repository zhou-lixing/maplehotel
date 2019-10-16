package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IMemberDao;
import com.maplegroup.maplehotel.dao.IRoomReserveDao;
import com.maplegroup.maplehotel.entity.Member;
import com.maplegroup.maplehotel.entity.ReserveInfo;
import com.maplegroup.maplehotel.service.IRoomReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoomReserveService implements IRoomReserveService {

    @Autowired
    private IRoomReserveDao roomReserveDao;

    @Autowired
    private IMemberDao memberDao;


    @Override
    public boolean addReserve(ReserveInfo reserveInfo, Member member) {
        if(memberDao.findMemberByName(member.getMemberName())==null){


            memberDao.addMember(member);

        }

        roomReserveDao.addReserve(reserveInfo);
        return true;

    }

    @Override
    public boolean delReserve(String reserveInfoRoomNumber) {

        roomReserveDao.delReserve(reserveInfoRoomNumber);

        return true;

    }

    @Override
    public boolean updateReserve(String reserveInfoRoomNumber) {

        roomReserveDao.updateReserve(reserveInfoRoomNumber);

        return true;
    }

    @Override
    public String findMaxIdOfOrderNum() {
        String maxIdOfOrderNum = roomReserveDao.findMaxIdOfOrderNum();
        return maxIdOfOrderNum;
    }

    @Override
    public ReserveInfo findReserveByRoomNumber(String reserveInfoRoomNumber) {
        ReserveInfo reserveInfo = roomReserveDao.findReserveByRoomNumber(reserveInfoRoomNumber);
        return reserveInfo;
    }

    @Override
    public ReserveInfo findReserveByBooker(String reserveInfoBooker) {
        ReserveInfo reserveInfo = roomReserveDao.findReserveByBooker(reserveInfoBooker);
        return reserveInfo;
    }

    @Override
    public List<ReserveInfo> findReserveByType(String reserveInfoRoomType) {
        List<ReserveInfo> reserveInfos = roomReserveDao.findReserveByType(reserveInfoRoomType);
        return reserveInfos;
    }

    @Override
    public List<ReserveInfo> findAllReserve() {
        List<ReserveInfo> reserveInfoAll = roomReserveDao.findAllReserve();
        return reserveInfoAll;
    }

    @Override
    public List<ReserveInfo> find(Map<String, String> map) {
        return roomReserveDao.find(map);
    }

    @Override
    public boolean cancelReserveStatus(String reserveInfoRoomNumber) {
        roomReserveDao.cancelReserveStatus(reserveInfoRoomNumber);
        return true;
    }


}
