package com.ssm.service.impl;

import com.ssm.dao.PermissionDao;
import com.ssm.domain.Permission;
import com.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public Permission findById(int id) {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
