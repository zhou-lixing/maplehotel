package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.RoomType;

import java.util.List;

public interface IRoomTypeService {

    //添加客房
    public boolean addRoomType(RoomType roomType);

    //删除客房
    public boolean deleteRoomType(String roomTypeNum);

    //修改客房
    public boolean updateByNum(String roonTypeNum);

    //查询客房类型
    RoomType findRoomTypeByNum(String roomTypeNum);
    //根据客房类型查询客房
    List<RoomType> findRoomByRoomType(String roomType);
    List<RoomType> findAll();
}
