package com.maplegroup.maplehotel.test;

import com.maplegroup.maplehotel.dao.*;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.entity.User;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class DaoTest {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IJournalDao journalDao;
    @Autowired
    private IRoomDao roomDao;
    @Autowired
    private IGoodsDao goodsDao;

    @Autowired
    private IGoodsTypeDao goodsTypeDao;
    @Test
    public void userDaoTest(){
        System.out.println(goodsDao.findGoodsAll());

    }


    @Test
    public void JournalDaoTest(){
//        Journal journal = new Journal();
//        journal.setJournalOperate("登录系统");
//        journal.setJournalUserName(userDao.findUserByUsername("周利星").getUserIdentifier());
//        journalDao.addJournal(journal);
        goodsTypeDao.findGoodsByGoodsType("饮料").forEach(System.out::println);
//        journalDao.findAllJournal().forEach(item-> System.out.println(item));
//        journalDao.findDateJournal("20190914","20190915").forEach(item-> System.out.println(item.getUser().getUserUsername()));
    }

}