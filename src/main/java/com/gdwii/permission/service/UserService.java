package com.gdwii.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdwii.permission.mapper.UserMapper;
import com.gdwii.permission.model.User;
import com.gdwii.vo.Result;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	private RoleService roleService;

	public Result addUser(User user){
		return new Result();
	}
}
