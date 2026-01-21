package com.userinfo.jdbc.service;

import com.userinfo.jdbc.dao.UserDao;
import com.userinfo.jdbc.dao.userDaoImp;
import com.userinfo.jdbc.model.User;

import java.util.List;

public class userServiceImp implements UserService{
UserDao userDao=new userDaoImp();
    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }
}
