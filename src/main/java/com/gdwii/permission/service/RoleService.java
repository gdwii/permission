package com.gdwii.permission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdwii.permission.mapper.RoleMapper;

@Service
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	
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
		return roleMapper.selectById(roleId) != null;
	}
}
