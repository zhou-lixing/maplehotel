package com.maplegroup.maplehotel.dao;


import com.maplegroup.maplehotel.entity.ReservationGuest;

import java.util.List;

public interface IReservationGuestDao {
    //根据客房编号查询
    List<ReservationGuest> findReservationGuestByRoomNum(String roomNum);
    //根据起始时间结束时间查询，默认都为当前时间
    List<ReservationGuest> findReservationGuestByDate(String startDate, String endDate);
    //查询全部信息
    List<ReservationGuest> findAll();
}
