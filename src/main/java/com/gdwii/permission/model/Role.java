package com.gdwii.permission.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -964416061964981426L;

	private Integer id;
	
	private String name;
	
	/**
	 * 是否可用
	 */
	private boolean available;
	
	private List<Permission> permissionList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
}
