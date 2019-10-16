package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Room;

import java.util.List;

public interface IRoomService {

    //添加客房
    public boolean addRoom(Room room);

    //删除客房
    public boolean deleteRoom(String roomNumber);

    //修改客房
    public boolean updateByNumber(String roomNumber);

    //查询客房
    Room findRoomByNumber(String roomNumber);
    List<Room> findRoomByType(String roomType);
    List<Room> findRoomByStatus(String roomStatus);
    List<Room> findRoomByFloor(String roomFloor);
    List<Room> findRoomByPrice(String roomPrice);
    List<Room> findRoomAll();
}
