package com.gdwii.permission.mapper;

import org.apache.ibatis.annotations.Select;

import com.gdwii.permission.model.Role;

import java.util.List;

public interface RoleMapper {
	@Select("SELETC * FROM sys_role WHERE id = #{id}")
	Role selectById(Integer id);

}
