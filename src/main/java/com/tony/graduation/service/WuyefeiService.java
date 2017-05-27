package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Wuyefei;

public interface WuyefeiService extends Serializable {

	public List<Wuyefei> findAll();
	
	public int insertwuyefei(Wuyefei wuyefei);
	
	public int updatewuyefei(Wuyefei wuyefei);
	
	public int deletewuyefei(Wuyefei wuyefei);
}
