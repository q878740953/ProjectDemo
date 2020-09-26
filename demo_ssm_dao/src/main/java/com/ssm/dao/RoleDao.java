package com.ssm.dao;

import com.ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    // 根据用户id查询该用户的所有角色信息
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ssm.dao.PermissionDao.findByRoleIdAndPermission"))
    })
    List<Role> findByUserIdAndRole(int id);
    // 查询所有角色信息
    @Select("select * from role")
    List<Role> findAll();
    // 添加新的角色
    @Select("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role);
    // 根据id查询详情的角色信息
    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ssm.dao.PermissionDao.findByRoleIdAndPermission"))
    })
    Role findById(int id);
}
