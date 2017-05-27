package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Shuifei;
import com.tony.graduation.entity.Wuyefei;

public interface WuyefeiDao extends Serializable {

	public List<Wuyefei> findAll();
	
	public int insertwuyefei(Wuyefei wuyefei);
	
	public int updatewuyefei(Wuyefei wuyefei);
	
	public int deletewuyefei(Wuyefei wuyefei);
	
	public List<Wuyefei> findByID(Wuyefei wuyefei);
}
