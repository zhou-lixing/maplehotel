package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.GuestsStaying;

import java.util.List;

public interface IGuestsStayingService {

    //根据客房编号查询
    List<GuestsStaying> findGuestsStayingByHomeNum(String homeNum);

    //根据起始时间结束时间查询，默认都为当前时间
    List<GuestsStaying> findGuestsStayingByDate(String startDate, String endDate);

    //查询所有
    List<GuestsStaying> findAll();
}
