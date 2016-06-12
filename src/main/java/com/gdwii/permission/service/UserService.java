package com.gdwii.permission.service;

import com.gdwii.permission.constants.ErrorCodePermission;
import com.gdwii.permission.dao.UserDao;
import com.gdwii.permission.model.User;
import com.gdwii.response.ErrorCodeBase;
import com.gdwii.response.Result;
import com.gdwii.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleService roleService;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Result addUser(User user){
		if(!exist(user.getUsername())){
			return new Result(ErrorCodePermission.用户名已存在);
		}
		if(!roleService.exist(user.getRoleIdList())){
			return new Result(ErrorCodePermission.权限不存在);
		}
		userDao.add(user);
		return new Result(ErrorCodeBase.Success);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Result updateUser(User user){
		User originalUser = userDao.getWithRoleIdById(user.getId());
		if(getUser(user.getId()) == null){
			return new Result(ErrorCodePermission.用户不存在);
		}
		if(!roleService.exist(user.getRoleIdList())){
			return new Result(ErrorCodePermission.权限不存在);
		}
		userDao.updateUser(originalUser, user);
		return new Result(ErrorCodeBase.Success);
	}

	public User getUser(Integer userId){
		if(userId == null){
			return null;
		}
		return userDao.getById(userId);
	}

    public boolean exist(String username){
		return StringUtils.isNotEmpty(username) && userDao.getByUsername(username) != null;
    }

	public User getUserWithRole(Integer userId) {
		if(userId == null){
			return null;
		}
		return userDao.getWithRoleById(userId);
	}
}
