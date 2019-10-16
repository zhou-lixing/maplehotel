package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Floor;

import java.util.List;

public interface IFloorService {
    //添加楼层
    public boolean addFloor(Floor floor);

    //删除楼层
    public boolean deleteFloor(String floorName);

    //修改楼层
    public boolean updateFloor(String floorName);

    //查询楼层
    Floor findFloorByName(String floorName);
    Floor findFloorByNum(String floorNum);

    List<Floor> findFloorAll();
}
