package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Journal;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IJournalDao {
    //产生日志
    int addJournal(Journal journal);
    //查看全部日志
    List<Journal> findAllJournal();
    //查看日期范围内的日志
    List<Journal> findDateJournal(String startDate,String endDate);
    //根据用户名查日志
    List<Journal> findJournalByUsername(String username);
}
