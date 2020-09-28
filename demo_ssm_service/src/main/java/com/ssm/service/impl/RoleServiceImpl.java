package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(int roleId) {
        return roleDao.findRoleByIdAndAllPermission(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) {
        for (int permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
