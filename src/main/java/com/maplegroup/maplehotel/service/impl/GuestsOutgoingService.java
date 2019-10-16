package com.maplegroup.maplehotel.service.impl;


import com.maplegroup.maplehotel.dao.IGuestsOutgoingDao;
import com.maplegroup.maplehotel.entity.GuestsOutgoing;
import com.maplegroup.maplehotel.service.IGuestsOutgoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuestsOutgoingService implements IGuestsOutgoingService {

    @Autowired
    private IGuestsOutgoingDao guestsOutgoingDao;

    @Override
    public List<GuestsOutgoing> findGuestsOutgoingByDate(String endDate) {

        return guestsOutgoingDao.findGuestsOutgoingByDate(endDate, Integer.parseInt(endDate)+1+"");
    }
}
