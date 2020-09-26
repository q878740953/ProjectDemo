package com.ssm.dao;

import com.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByRoleIdAndPermission(int id);
    // 查询所有的资源权限管理
    @Select("select * from permission")
    List<Permission> findAll();
    @Select("select * from permission where id=#{id}")
    Permission findById(int id);
    // 保存新的资源管理权限
    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    void save(Permission permission);
}
