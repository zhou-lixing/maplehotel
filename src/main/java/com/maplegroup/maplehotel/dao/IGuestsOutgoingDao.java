package com.maplegroup.maplehotel.dao;


import com.maplegroup.maplehotel.entity.GuestsOutgoing;

import java.util.List;

public interface IGuestsOutgoingDao {

    //根据离店时间查询
    List<GuestsOutgoing> findGuestsOutgoingByDate(String endDate1, String endDate2);
}
