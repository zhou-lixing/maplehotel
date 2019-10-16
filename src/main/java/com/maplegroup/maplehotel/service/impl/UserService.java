package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IJournalDao;
import com.maplegroup.maplehotel.dao.IUserDao;
import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.entity.User;
import com.maplegroup.maplehotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IJournalDao journalDao;

    private static Journal journal=null;

    static {
        journal = new Journal();
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public int getUserPower(String username) {
        if(userDao.findUserByUsername(username)!=null){
            return userDao.findUserByUsername(username).getUserPower();
        }
        return 0;
    }

    @Override
    public boolean addUser(User Operator,User user) {
        //判断用户是否存在
        if(userDao.findUserByUsername(user.getUserUsername())==null){
            //生成用户编号
            int userId = Integer.parseInt(userDao.getMaxId()) + 1;//当前最大编号值加一
            //构造用户信息
            user.setUserIdentifier(userId+"");
            //信息插入数据库
            if(userDao.addUser(user) > 0){
                //生成日志
                journal.setJournalUserName(Operator.getUserIdentifier());
                journal.setJournalOperate("添加用户\""+user.getUserUsername()+"\"");
                journalDao.addJournal(journal);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean userLogin(User user) {
        User dbUser = userDao.findUserByUsername(user.getUserUsername());
        if(dbUser!=null && dbUser.getUserPassword().equals(user.getUserPassword())){
            //生成日志
            journal.setJournalUserName(userDao.findUserByUsername(user.getUserUsername()).getUserIdentifier());
            journal.setJournalOperate("登录系统");
            journalDao.addJournal(journal);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User Operator,User user) {
        if(userDao.findUserByUsername(user.getUserUsername())!=null){
            if(userDao.updateUser(user)>0){
                journal.setJournalUserName(Operator.getUserIdentifier());
                journal.setJournalOperate("更新用户：\""+user.getUserUsername()+"\"的信息");
                journalDao.addJournal(journal);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(User Operator,String username) {
        //获取数据库对象
        User dbUser = userDao.findUserByUsername(username);
        if (dbUser!=null){
            if(userDao.deleteUser(dbUser.getUserIdentifier())>0){
                journal.setJournalUserName(Operator.getUserIdentifier());
                journal.setJournalOperate("删除用户：\""+username+"\"");
                journalDao.addJournal(journal);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }


}
