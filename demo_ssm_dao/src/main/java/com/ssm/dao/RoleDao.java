package com.ssm.dao;

import com.ssm.domain.Permission;
import com.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

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
    List<Role> findUserByIdAndAllRole(int id);
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
    // 通过角色的id去查询角色下还没有被关联的权限信息
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findRoleByIdAndAllPermission(int roleId);
    @Insert("insert into role_permission(roleId, permissionId) values(#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
