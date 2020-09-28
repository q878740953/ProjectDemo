package com.ssm.controller;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(Model model, @RequestParam(name = "id", required = true) int roleId){
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(roleId);
        model.addAttribute("role", role);
        model.addAttribute("permissionList", permissionList);
        return "role-permission-add";
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "id", required = true) int roleId, @RequestParam(name = "ids", required = true) int[] permissionIds){
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect: findAll";
    }
}
