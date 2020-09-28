package com.ssm.service;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(int id);

    List<Permission> findRoleByIdAndAllPermission(int roleId);

    void addPermissionToRole(int roleId, int[] permissionIds);
}
