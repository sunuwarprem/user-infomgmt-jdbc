package com.userinfo.jdbc.service;

import com.userinfo.jdbc.model.User;

import java.util.List;

public interface UserService {
    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
    List<User> listUser();
}
