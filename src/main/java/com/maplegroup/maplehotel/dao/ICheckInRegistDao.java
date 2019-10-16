package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.CheckInInfo;
import com.maplegroup.maplehotel.entity.ReserveInfo;

import java.util.List;
import java.util.Map;

public interface ICheckInRegistDao {

    //添加入住登记用户
    void addCheckIn(CheckInInfo checkInInfo);
    //根据房号删除
    void delCheckIn(String checkInInfoHomeNum);
    //根据房号修改
    void updateCheckIn(String checkInInfoHomeNum);
    //查找最大ID号所对应的入住单号
    String findMaxIdOfCheckInNum();
    //根据房号查询
    CheckInInfo findCheckInByHomeNumber(String checkInInfoHomeNum);
    //根据入住人查询
    CheckInInfo findCheckInByHuman(String checkInInfoHuman);
    //根据客房类型查询
    List<CheckInInfo> findCheckInByType(String checkInInfoRoomType);
    //查询所有
    List<CheckInInfo> findAllCheckIn();

    List<CheckInInfo> find(Map<String,String> map);
}
