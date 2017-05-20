package com.tony.graduation.entity;

import java.io.Serializable;

public class Zichan implements Serializable {

	private String id;
	private String mingcheng;
	private String suoyouzhe;
	private String weihuzhe;
	private String state;
	private String weizhi;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public String getSuoyouzhe() {
		return suoyouzhe;
	}
	public void setSuoyouzhe(String suoyouzhe) {
		this.suoyouzhe = suoyouzhe;
	}
	public String getWeihuzhe() {
		return weihuzhe;
	}
	public void setWeihuzhe(String weihuzhe) {
		this.weihuzhe = weihuzhe;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWeizhi() {
		return weizhi;
	}
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	
}
