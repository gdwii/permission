package com.gdwii.permission.dao;

import com.gdwii.permission.mapper.UserMapper;
import com.gdwii.permission.model.User;
import com.gdwii.util.mybatis.MybatisUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public void add(User user) {
        userMapper.insert(user);
        // 保存用户-角色关系
        addUserRole(user.getId(), user.getRoleIdList());
    }

    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    public User getWithRoleIdById(Integer id) {
        return userMapper.getWithRoleIdById(id);
    }

    public void updateUser(User originalUser, User user) {
        if (!originalUser.equalsWithBaseInfo(user)) {
            userMapper.updateWithoutPswd(user);
        }
        List<Integer> originalRoleIdList = originalUser.getRoleIdList();
        List<Integer> roleIdList = user.getRoleIdList();
        if(originalRoleIdList.equals(roleIdList)){
            return;
        }

        List<Integer> originalRoleIdListCopy = new ArrayList<>(originalRoleIdList.size());
        Collections.copy(originalRoleIdListCopy, originalRoleIdList);
        // 删除不需要的用户-角色
        originalRoleIdList.removeAll(roleIdList);
        removeUserRole(user.getId(), originalRoleIdList);
        // 新增用户-角色
        roleIdList.removeAll(originalRoleIdListCopy);
        addUserRole(user.getId(), roleIdList);
    }

    private void addUserRole(Integer userId, List<Integer> roleIdList){
        MybatisUtil.batchOperator((mapper, value) -> mapper.insertUserRole(userId, value), UserMapper.class, roleIdList);
    }

    private void removeUserRole(Integer userId, List<Integer> roleIdList){
        MybatisUtil.batchOperator((mapper, value) -> mapper.deleteUserRole(userId, value), UserMapper.class, roleIdList);
    }

    public User getWithRoleById(Integer id) {
        return userMapper.getWithRoleById(id);
    }
}
