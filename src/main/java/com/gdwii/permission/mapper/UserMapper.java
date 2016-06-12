package com.gdwii.permission.mapper;

import com.gdwii.permission.model.Role;
import com.gdwii.permission.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM sys_user FROM username = #{username}")
    User selectByUsername(String username);

    @Insert("INSERT INTO sys_user(username, realname, password, salt, locked) VALUES (#{username}, #{realname}, #{password}, #{salt}, #{locked})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Insert("INSERT INTO sys_user_role(userId, roleId) VALUES (#{usreId}, #{roleId})")
    void insertUserRole(@Param("userId") Integer userId, @Param("roleId")Integer roleId);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    User selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    @Results(
            @Result(column = "roleIdList" , one = @One(select = "SELECT roleId FROM sys_user_role WHERE userId = #{id} ORDER BY roleId"))
    )
    User getWithRoleIdById(Integer id);

    @Delete("DELETE FROM sys_user WHERE userId = #{usreId} AND roleId = #{roleId}")
    void deleteUserRole(@Param("userId") Integer userId, @Param("roleId") Integer value);

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "username", property = "username"),
        @Result(column = "realname", property = "realname"),
        @Result(property = "locked", column = "locked"),
        @Result(column = "id", property = "roleList",
                one = @One(fetchType = FetchType.EAGER,select = "com.gdwii.permission.mapper.UserMapper.selectRoleByUserId"))
    })
    User getWithRoleById(Integer id);

    @Update("UPDATE sys_user SET username = #{username}, realname = #{realname}, salt = #{salt}, locked = #{locked} WHERE id = #{id}" )
    void updateWithoutPswd(User user);

    @Select("SELECT r.* FROM sys_user_role ur LEFT JOIN sys_role r ON ur.roleId = r.Id WHERE ur.userId = #{userId} ORDER BY ur.roleId")
    List<Role> selectRoleByUserId(Integer userId);
}
