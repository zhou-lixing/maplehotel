package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Room;

import java.util.List;

public interface IRoomDao {
    //根据编号查询客房
    Room findRoomByNumber(String roomNumber);
    //根据类型查询客房
    List<Room> findRoomByType(String roomType);
    //根据状态查询客房
    List<Room> findRoomByStatus(String roomStatus);
    //根据楼层查询客房
    List<Room> findRoomByFloor(String roomFloor);
    //根据价格查询客房
    List<Room> findRoomByPrice(String roomPrice);

    //添加客房
    void addRoom(Room room);
    //删除客房
    int deleteRoom(String roomNumber);
    //查询所有客房
    List<Room> findRoomAll();
    //修改客房
    int updateByNumber(String roomNumber);
}
