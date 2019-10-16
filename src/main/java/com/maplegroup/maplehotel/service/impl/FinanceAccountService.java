package com.maplegroup.maplehotel.service.impl;


import com.maplegroup.maplehotel.dao.IFinanceAccountDao;
import com.maplegroup.maplehotel.entity.FinanceAccount;
import com.maplegroup.maplehotel.service.IFinanceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FinanceAccountService implements IFinanceAccountService {

    @Autowired
    private IFinanceAccountDao financeAccountDao;

    @Override
    public List<FinanceAccount> findFinanceAccountByDate(String Date) {

        return financeAccountDao.findFinanceAccountByDate(Date, Integer.parseInt(Date)+1+"");
    }
}
