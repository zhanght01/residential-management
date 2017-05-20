package com.tony.graduation.entity;

import java.io.Serializable;

public class Park implements Serializable {
	
	private String id;
	private String cheweihao;
	private String state;
	private String suoyouren;
	private String jiage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCheweihao() {
		return cheweihao;
	}
	public void setCheweihao(String cheweihao) {
		this.cheweihao = cheweihao;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSuoyouren() {
		return suoyouren;
	}
	public void setSuoyouren(String suoyouren) {
		this.suoyouren = suoyouren;
	}
	public String getJiage() {
		return jiage;
	}
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	
}
