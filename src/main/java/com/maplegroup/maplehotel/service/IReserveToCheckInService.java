package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.CheckInInfo;

public interface IReserveToCheckInService {

    //根据房号删除预定信息
    boolean delReserveInfo(String reserveInfoRoomNumber);

    //添加入住信息
    boolean addToCheckIn(CheckInInfo checkInInfo);

}
