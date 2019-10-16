package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IRoomTypeDao;
import com.maplegroup.maplehotel.entity.RoomType;
import com.maplegroup.maplehotel.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeService implements IRoomTypeService {

    @Autowired
    private IRoomTypeDao roomTypeDao;

    @Override
    public boolean addRoomType(RoomType roomType) {
        if (roomTypeDao.findRoomTypeByNum(roomType.getRoomTypeNum())==null){
            roomTypeDao.addRoomType(roomType);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoomType(String roomTypeNum) {
        if (roomTypeDao.deleteRoomType(roomTypeNum)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean updateByNum(String roonTypeNum) {
        if (roomTypeDao.updateByNum(roonTypeNum)>0){
            return true;
        }

        return false;
    }

    @Override
    public RoomType findRoomTypeByNum(String roomTypeNum) {
        RoomType roomType = roomTypeDao.findRoomTypeByNum(roomTypeNum);
        return roomType;
    }


    @Override
    public List<RoomType> findRoomByRoomType(String roomType) {
        List<RoomType> roomTypeList = roomTypeDao.findRoomByRoomType(roomType);
        return roomTypeList;
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeDao.findRoomTypeAll();
    }

}
