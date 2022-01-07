package com.xian.service.Impl;

import com.xian.mapper.UserMapper;
import com.xian.pojo.User;
import com.xian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean checkLogin(User user) {
        List<User> result = userMapper.checkLoginUser(user);
        if (result.size()>0&&result.get(0).getPass_word().equals(user.getPass_word())) {
            user.setPower(result.get(0).getPower());
            return true;
        }
        return false;
    }

    @Override
    public boolean registe(User user) {
        user.setPower(0);
        return userMapper.registe(user)>0;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> searchUser(User user) {
        return userMapper.searchUser(user);
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.add(user)>0;
    }

    @Override
    public Boolean modifyUser(User user) {
        return userMapper.update(user)>0;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id)>0;
    }
}
