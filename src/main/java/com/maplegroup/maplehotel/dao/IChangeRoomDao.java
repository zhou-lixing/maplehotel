package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.ChangeRoom;

public interface IChangeRoomDao {

    //添加换房信息
    void addToChange(ChangeRoom changeRoom);

    //通过房号查询换房信息
    ChangeRoom findByHomeNum(String changeHomeAfterHomeNum);

}
