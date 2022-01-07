package com.xian.service;

import com.xian.pojo.User;

import java.util.List;

public interface UserService {
    boolean checkLogin(User user);

    boolean registe(User user);

    List<User> findAll();

    List<User> searchUser(User user);

    Boolean addUser(User user);

    Boolean modifyUser(User user);

    Boolean deleteUser(Integer id);
}
