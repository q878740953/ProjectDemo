package com.ssm.controller;

import com.ssm.domain.Permission;
import com.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";
    }
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(required = true, defaultValue = "1") int id){
        Permission permission = permissionService.findById(id);
        model.addAttribute("permission", permission);
        return "permission-show";
    }
    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }
}
