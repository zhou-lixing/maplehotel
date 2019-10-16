package com.maplegroup.maplehotel.test;

import com.maplegroup.maplehotel.dao.IJournalDao;
import com.maplegroup.maplehotel.dao.IUserDao;
import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.service.IJournalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class JournalServiceTest {
    @Autowired
    private IJournalService journalService;
    @Autowired
    private IUserDao userDao;

    @Test
    public void findAllJournalTest(){
        journalService.findAllJournal().forEach(System.out::println);
    }

    @Test
    public void findJournalByDateTest(){
        journalService.findJournalByDate("20190919","20190919").forEach(System.out::println);
    }

    @Test
    public void findJournalByUsernameTest(){
        journalService.findJournalByUsername("周利星").forEach(System.out::println);
    }

}
