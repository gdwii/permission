package com.gdwii.permission.dao;

import com.gdwii.permission.mapper.RoleMapper;
import com.gdwii.permission.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    @Autowired
    private RoleMapper roleMapper;

    public Role getById(Integer roleId) {
        return roleMapper.selectById(roleId);
    }
}
