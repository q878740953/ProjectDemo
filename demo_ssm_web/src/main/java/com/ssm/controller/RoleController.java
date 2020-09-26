package com.ssm.controller;

import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }

    @RequestMapping("/findById")
    public String findById(Model model, int id) {
        Role role = roleService.findById(id);
        model.addAttribute("role", role);
        return "role-show";
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll";
    }

}
