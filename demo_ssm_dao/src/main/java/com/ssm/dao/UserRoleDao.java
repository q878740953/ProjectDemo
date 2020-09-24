package com.ssm.dao;

import com.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    List<Role> findByUserId(int userId);
}
