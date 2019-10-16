package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IChangeRoomDao;
import com.maplegroup.maplehotel.entity.ChangeRoom;
import com.maplegroup.maplehotel.service.IChangeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChangeRoomService implements IChangeRoomService {

    @Autowired
    private IChangeRoomDao changeRoomDao;

    @Override
    public boolean addToChange(ChangeRoom changeRoom) {

        changeRoomDao.addToChange(changeRoom);

        return true;
    }

    @Override
    public ChangeRoom findByHomeNum(String changeHomeAfterHomeNum) {

        ChangeRoom changeRoom = changeRoomDao.findByHomeNum(changeHomeAfterHomeNum);

        return changeRoom;
    }
}
