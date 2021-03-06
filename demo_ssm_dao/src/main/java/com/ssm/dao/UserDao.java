package com.ssm.dao;

import com.ssm.domain.Role;
import com.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,many = @Many(select = "com.ssm.dao.RoleDao.findUserByIdAndAllRole"))
    })
    UserInfo findByName(String username);
    @Select("select * from users")
    List<UserInfo> findAllUser();
    @Insert("insert into users(email, username, password, phoneNum, status) values(#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    void saveUser(UserInfo userInfo);
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.ssm.dao.RoleDao.findUserByIdAndAllRole"))
    })
    UserInfo findById(int id);
    // 通过用户的id查询出所有的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    List<Role> findAllRole(int userId);
    @Insert("insert into users_role (userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
