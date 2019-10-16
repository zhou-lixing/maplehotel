package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.ICheckOutAccountsDao;
import com.maplegroup.maplehotel.entity.CheckOutAccounts;
import com.maplegroup.maplehotel.service.ICheckOutAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckOutAccountsService implements ICheckOutAccountsService {

    @Autowired
    private ICheckOutAccountsDao checkOutAccountsDao;

    @Override
    public boolean addToCheckOut(CheckOutAccounts checkOutAccounts) {
        checkOutAccountsDao.addToCheckOut(checkOutAccounts);
        return true;
    }

    @Override
    public String findMaxIdOfNum() {
        return checkOutAccountsDao.findMaxIdOfNum();
    }

    @Override
    public CheckOutAccounts findByHomeNum(String checkOutHomeNum) {

        CheckOutAccounts checkOutAccounts = checkOutAccountsDao.findByHomeNum(checkOutHomeNum);
        return checkOutAccounts;
    }
}
