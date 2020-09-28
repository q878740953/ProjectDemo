package com.ssm.controller;

import com.ssm.dao.RoleDao;
import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import com.ssm.service.RoleService;
import com.ssm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
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
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model, @RequestParam(name = "id", required = true)int userId){
        UserInfo userInfo = userService.findById(userId);
        List<Role> existRoleList = userService.findAllRole(userId);
        List<Role> roleList = roleService.findAll();
        model.addAttribute("user", userInfo);
        model.addAttribute("roleList", roleList);
        model.addAttribute("existRoleList", existRoleList);
        return "user-role-add";
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "id", required = true) int userId, @RequestParam(name = "ids", required = true)  int[] roleIds){
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll";
    }
}
