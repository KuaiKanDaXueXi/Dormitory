package com.xian.controller;

import com.xian.pojo.User;
import com.xian.service.UserService;
import com.xian.utlis.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping("/search")
    public List<User> search(@RequestBody User user){
        System.out.println(user);
        return userService.searchUser(user);
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody User user){
        user.setPass_word(MD5Util.MD5EncodeUtf8(user.getPass_word()));
        return userService.addUser(user);
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }
    @PostMapping("/modify")
    public Boolean modify(@RequestBody User user){
        return userService.modifyUser(user);
    }
}
