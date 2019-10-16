package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Floor;

import java.util.List;

public interface IFloorDao {
    //根据楼层名查询楼层
    Floor findFloorByName(String floorName);

    Floor findFloorByNum(String floorNum);
    //根据楼层查询客房
    List<Floor> findRoomByFloor(String floor);

    //添加楼层
    void addFloor(Floor floor);

    //删除楼层
    int deleteFloor(String floorName);
    //查询所有楼层
    List<Floor> findFloorAll();
    //修改楼层
    int updateByNum(String floorNum);
}
