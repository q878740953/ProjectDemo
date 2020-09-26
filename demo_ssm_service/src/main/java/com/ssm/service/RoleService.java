package com.ssm.service;

import com.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(int id);
}
