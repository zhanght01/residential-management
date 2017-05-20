package com.tony.graduation.entity;

import java.io.Serializable;

public class Weixiu implements Serializable {
	
	private String id;
	private String yezhuname;
	private String baoxiuneirong;
	private String phone;
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
	public String getBaoxiuneirong() {
		return baoxiuneirong;
	}
	public void setBaoxiuneirong(String baoxiuneirong) {
		this.baoxiuneirong = baoxiuneirong;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
