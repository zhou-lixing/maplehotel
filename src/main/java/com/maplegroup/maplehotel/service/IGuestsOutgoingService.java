package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.GuestsOutgoing;

import java.util.List;

public interface IGuestsOutgoingService {

    //根据离店时间查询
    List<GuestsOutgoing> findGuestsOutgoingByDate(String endDate);
}
