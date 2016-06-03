package com.gdwii.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611513216656467186L;

	public int id;
	
	private String name;
	
	/*private String s;*/
	
	private LocalDateTime birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	
/*	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}*/

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + /*", s=" + s +*/ ", birthday=" + birthday + "]";
	}
}
