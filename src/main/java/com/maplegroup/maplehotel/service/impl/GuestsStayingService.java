package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IGuestsStayingDao;
import com.maplegroup.maplehotel.entity.GuestsStaying;
import com.maplegroup.maplehotel.service.IGuestsStayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuestsStayingService implements IGuestsStayingService {

    @Autowired
    private IGuestsStayingDao guestsStayingDao;

    @Override
    public List<GuestsStaying> findGuestsStayingByHomeNum(String homeNum) {
        return guestsStayingDao.findGuestsStayingByHomeNum(homeNum);
    }

    @Override
    public List<GuestsStaying> findGuestsStayingByDate(String startDate, String endDate) {

        return guestsStayingDao.findGuestsStayingByDate(startDate,Integer.parseInt(endDate)+1+"");
    }

    @Override
    public List<GuestsStaying> findAll() {
        return guestsStayingDao.findAll();
    }
}
