package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.ICheckInRegistDao;
import com.maplegroup.maplehotel.dao.IReserveToCheckInDao;
import com.maplegroup.maplehotel.dao.IRoomReserveDao;
import com.maplegroup.maplehotel.entity.CheckInInfo;
import com.maplegroup.maplehotel.service.IReserveToCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReserveToCheckInService implements IReserveToCheckInService {

    @Autowired
    private IRoomReserveDao roomReserveDao;

    @Autowired
    private ICheckInRegistDao checkInRegistDao;


    @Override
    public boolean delReserveInfo(String reserveInfoRoomNumber) {

        roomReserveDao.delReserve(reserveInfoRoomNumber);

        return true;
    }

    @Override
    public boolean addToCheckIn(CheckInInfo checkInInfo) {

        checkInRegistDao.addCheckIn(checkInInfo);

        return true;
    }
}
