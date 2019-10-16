package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Journal;

import java.util.List;

public interface IJournalService {
    //查询全部日志
    List<Journal> findAllJournal();
    //查询日期范围内的日志
    List<Journal> findJournalByDate(String startDate,String endDate);
    //查询用户的日志
    List<Journal> findJournalByUsername(String username);
}
