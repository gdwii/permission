package com.gdwii.permission.service;

import com.gdwii.permission.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public boolean exist(List<Integer> roleIdList){
		if(roleIdList == null || roleIdList.isEmpty()){
			return true;
		}
		for(Integer roleId : roleIdList){
			if(!exist(roleId)){
				return false;
			}
		}
		return true;
	}
	
	public boolean exist(Integer roleId){
		return roleDao.getById(roleId) != null;
	}
}
