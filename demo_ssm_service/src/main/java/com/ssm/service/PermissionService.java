package com.ssm.service;

import com.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    Permission findById(int id);

    void save(Permission permission);
}
