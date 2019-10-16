package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IReservationGuestDao;
import com.maplegroup.maplehotel.entity.ReservationGuest;
import com.maplegroup.maplehotel.service.IReservationGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationGuestService implements IReservationGuestService {

    @Autowired
    private IReservationGuestDao reservationGuestDao;

    @Override
    public List<ReservationGuest> findReservationGuestByRoomNum(String roomNum) {
          return reservationGuestDao.findReservationGuestByRoomNum(roomNum);
    }

    @Override
    public List<ReservationGuest> findReservationGuestByDate(String startDate, String endDate) {

        return reservationGuestDao.findReservationGuestByDate(startDate, Integer.parseInt(endDate)+1+"");


    }

    @Override
    public List<ReservationGuest> findAll() {
        return reservationGuestDao.findAll();
    }
}
