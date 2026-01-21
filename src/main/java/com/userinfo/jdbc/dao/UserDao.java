package com.userinfo.jdbc.dao;

import com.userinfo.jdbc.model.User;

import java.util.List;

public interface UserDao {
    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> listUser();
}
