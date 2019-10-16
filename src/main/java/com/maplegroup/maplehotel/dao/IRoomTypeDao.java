package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.RoomType;

import java.util.List;

public interface IRoomTypeDao {
    //查询客房类型
    RoomType findRoomTypeByNum(String roomTypeNum);
    //根据客房类型查询客房
    List<RoomType> findRoomByRoomType(String roomType);
    //添加客房类型
    void addRoomType(RoomType roomType);
    //删除客房
    int deleteRoomType(String roomTypeNum);
    //查询所有客房类型
    List<RoomType> findRoomTypeAll();
    //修改客房类型
    int updateByNum(String roomTypeNum);
}
