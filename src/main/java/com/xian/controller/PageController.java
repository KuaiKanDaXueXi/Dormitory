package com.xian.controller;

import com.xian.pojo.User;
import com.xian.service.UserService;
import com.xian.utlis.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String jumpToLogin(){
        return "forward:/login.html";
    }
    @PostMapping("/login")
    @ResponseBody
    public Boolean login(@RequestBody User user, HttpSession session){
        user.setPass_word(MD5Util.MD5EncodeUtf8(user.getPass_word()));
        if(userService.checkLogin(user)) {
            session.setAttribute("loginUser",user);
            return true;
        }
        return false;
    }
    @GetMapping("/index")
    public String jumpToIndex(HttpSession session){
        if (session.getAttribute("loginUser")!=null){
            return "index";
        } else {
            return "redirect:/login";
        }
    }
    @PostMapping("/registe")
    @ResponseBody
    public Boolean registe(@RequestBody User user, HttpSession session){
        user.setPass_word(MD5Util.MD5EncodeUtf8(user.getPass_word()));
        if(userService.registe(user)) {
            session.setAttribute("loginUser",user);
            return true;
        }
        return false;
    }
    @GetMapping("/exit")
    @ResponseBody
    public void exit(HttpSession session){
        session.removeAttribute("loginUser");
    }
}
