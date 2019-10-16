package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.ReservationGuest;

import java.util.List;

public interface IReservationGuestService {

    //根据客房编号查询
    List<ReservationGuest> findReservationGuestByRoomNum(String roomNum);

    //根据起始时间结束时间查询，默认都为当前时间
    List<ReservationGuest> findReservationGuestByDate(String startDate, String endDate);

    //查询所有
    List<ReservationGuest> findAll();
}
