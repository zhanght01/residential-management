package com.tony.graduation.entity;

import java.io.Serializable;

public class Userid implements Serializable {
	
	private String id;
	private String num;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
