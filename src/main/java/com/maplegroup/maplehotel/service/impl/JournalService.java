package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IJournalDao;
import com.maplegroup.maplehotel.dao.IUserDao;
import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.entity.User;
import com.maplegroup.maplehotel.service.IJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JournalService implements IJournalService {
    @Autowired
    private IJournalDao journalDao;
    @Autowired
    private IUserDao userDao;


    @Override
    public List<Journal> findAllJournal() {
        return journalDao.findAllJournal();
    }

    @Override
    public List<Journal> findJournalByDate(String startDate, String endDate) {
        //按照日期查询日志信息，在结束日期上加一之后得到正确的日期范围日志
        return journalDao.findDateJournal(startDate,(Integer.parseInt(endDate)+1)+"");
    }

    @Override
    public List<Journal> findJournalByUsername(String username) {
        User dbUser = userDao.findUserByUsername(username);
        if(dbUser!=null){
            return journalDao.findJournalByUsername(username);
        }
        return null;
    }

}
