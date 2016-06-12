package com.gdwii.permission.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2924677829513854232L;

	private Integer id;
	
	private String username;
	
	private String realname;
	
	private String password;
	
	/**
	 * 密码盐
	 */
	private String salt;
	
	/**
	 * 账号是否锁定
	 */
	private boolean locked;
	
	private List<Role> roleList;

    /**
     * 角色id列表（是按主键排好序的）
     */
	private List<Integer> roleIdList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Integer> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		if (locked != user.locked) return false;
		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (realname != null ? !realname.equals(user.realname) : user.realname != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
		if (roleList != null ? !roleList.equals(user.roleList) : user.roleList != null) return false;
		return roleIdList != null ? roleIdList.equals(user.roleIdList) : user.roleIdList == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (realname != null ? realname.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (salt != null ? salt.hashCode() : 0);
		result = 31 * result + (locked ? 1 : 0);
		result = 31 * result + (roleList != null ? roleList.hashCode() : 0);
		result = 31 * result + (roleIdList != null ? roleIdList.hashCode() : 0);
		return result;
	}

	public boolean equalsWithBaseInfo(User user) {
		if (locked != user.locked) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (realname != null ? !realname.equals(user.realname) : user.realname != null) return false;
		if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
		return true;
	}
}
