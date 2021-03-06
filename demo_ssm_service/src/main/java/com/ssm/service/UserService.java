package com.ssm.service;

import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAllUser();

    void saveUser(UserInfo userInfo);

    UserInfo findById(int id);

    List<Role> findAllRole(int userId);

    void addRoleToUser(int userId, int[] ids);
}
