package com.maplegroup.maplehotel.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.maplegroup.maplehotel.dao.IFloorDao;
import com.maplegroup.maplehotel.entity.Floor;
import com.maplegroup.maplehotel.service.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FloorService implements IFloorService {

    @Autowired
    private IFloorDao floorDao;

    @Override
    public boolean addFloor(Floor floor) {
        if (floorDao.findFloorByName(floor.getFloorName())==null) {
            floorDao.addFloor(floor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFloor(String floorName) {
        if (floorDao.deleteFloor(floorName)>0){
            return true;
        }
        return false;

    }

    @Override
    public boolean updateFloor(String floorNum) {
        if (floorDao.updateByNum(floorNum)>0){
            return true;
        }
        return false;

    }

    @Override
    public Floor findFloorByName(String floorName) {
        Floor floor = floorDao.findFloorByName(floorName);
        return floor;
    }

    @Override
    public Floor findFloorByNum(String floorNum) {
        Floor floor = floorDao.findFloorByNum(floorNum);
        return floor;
    }

    @Override
    public List<Floor> findFloorAll() {
        List<Floor> floorList=floorDao.findFloorAll();
        return floorList;
    }
}
