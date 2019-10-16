package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.FinanceAccount;

import java.util.List;

public interface IFinanceAccountDao {
    //查询当天进账信息
    List<FinanceAccount> findFinanceAccountByDate(String Date1, String Date2);
}
