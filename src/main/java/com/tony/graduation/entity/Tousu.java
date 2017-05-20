package com.tony.graduation.entity;

import java.io.Serializable;

public class Tousu implements Serializable {
	
	private String id;
	private String yezhuname;
	private String neirong;
	private String phone;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYezhuname() {
		return yezhuname;
	}
	public void setYezhuname(String yezhuname) {
		this.yezhuname = yezhuname;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
