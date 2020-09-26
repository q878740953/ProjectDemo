package com.ssm.controller;

import com.ssm.domain.UserInfo;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAllUser(Model model){
        List<UserInfo> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "user-list";
    }
    @RequestMapping("/save")
    public String saveUser(UserInfo userInfo){
        System.out.println(userInfo);
        userService.saveUser(userInfo);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public String findById(Model model, int id){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("userInfo", userInfo);
        return "user-show";
    }
}
