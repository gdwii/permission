package com.gdwii.permission.model;

import java.io.Serializable;

/**
 * 资源
 */
public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622900344275132112L;

	private Integer id;
	
	private String name;
	
	/**
	 * 资源类型：menu,button
	 */
	private String type;
	
	/**
	 * 访问url地址
	 */
	private String url;
	
	/**
	 * 权限代码字符串
	 */
	private String percode;
	
	/**
	 * 父结点id
	 */
	private Integer parentId;
	
	/**
	 * 父结点id列表串
	 */
	private String parentids;
	
	/**
	 * 排序号
	 */
	private String sortString;
	
	/**
	 * 是否可用
	 */
	private boolean available;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	public String getSortString() {
		return sortString;
	}

	public void setSortString(String sortString) {
		this.sortString = sortString;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
