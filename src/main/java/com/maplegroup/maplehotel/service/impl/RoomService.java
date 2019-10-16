package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IRoomDao;
import com.maplegroup.maplehotel.entity.Room;
import com.maplegroup.maplehotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Override
    public boolean addRoom(Room room) {
        if (roomDao.findRoomByNumber(room.getRoomNumber())==null){
            roomDao.addRoom(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String roomNumber) {
        if (roomDao.deleteRoom(roomNumber)>0){
            return true;
        }
        return false;

    }

    @Override
    public boolean updateByNumber(String roomNumber) {
        if (roomDao.updateByNumber(roomNumber)>0){
            return true;
        }
        return false;

    }

    @Override
    public Room findRoomByNumber(String roomNumber) {
        Room room = roomDao.findRoomByNumber(roomNumber);
        return room;
    }

    @Override
    public List<Room> findRoomByType(String roomType) {
        List<Room> roomList = roomDao.findRoomByType(roomType);
        return roomList;
    }

    @Override
    public List<Room> findRoomByStatus(String roomStatus) {
        List<Room> roomList = roomDao.findRoomByStatus(roomStatus);
        return roomList;
    }

    @Override
    public List<Room> findRoomByFloor(String roomFloor) {
        List<Room> roomList = roomDao.findRoomByFloor(roomFloor);
        return roomList;
    }

    @Override
    public List<Room> findRoomByPrice(String roomPrice) {
        List<Room> roomList = roomDao.findRoomByPrice(roomPrice);
        return roomList;
    }

    @Override
    public List<Room> findRoomAll() {
        List<Room> roomList = roomDao.findRoomAll();
        return roomList;
    }
}
