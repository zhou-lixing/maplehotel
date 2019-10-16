package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.CheckOutAccounts;

public interface ICheckOutAccountsDao {

    //添加退房信息
    void addToCheckOut(CheckOutAccounts checkOutAccounts);

    //查找最大ID号所对应的退房结账单号
    String findMaxIdOfNum();

    //根据房号查找信息
    CheckOutAccounts findByHomeNum(String checkOutHomeNum);

}
