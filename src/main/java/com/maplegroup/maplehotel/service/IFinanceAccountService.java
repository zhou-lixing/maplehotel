package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.FinanceAccount;

import java.util.List;

public interface IFinanceAccountService {

    //查询当天进账信息
    List<FinanceAccount> findFinanceAccountByDate(String Date);
}
