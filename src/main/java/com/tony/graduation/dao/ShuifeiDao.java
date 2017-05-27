package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Shuifei;

public interface ShuifeiDao extends Serializable {

	public List<Shuifei> findAll();
	
	public int insertshuifei(Shuifei shuifei);
	
	public int updateshuifei(Shuifei shuifei);
	
	public int deleteshuifei(Shuifei shuifei);
}
