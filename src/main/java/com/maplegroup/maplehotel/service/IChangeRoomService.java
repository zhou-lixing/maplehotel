package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.ChangeRoom;
import com.maplegroup.maplehotel.entity.CheckOutAccounts;

public interface IChangeRoomService {

    //添加换房信息
    boolean addToChange(ChangeRoom changeRoom);

    //通过房号查询换房信息
    ChangeRoom findByHomeNum(String changeHomeAfterHomeNum);

}
