package com.tony.graduation.service;

import java.util.List;

import com.tony.graduation.entity.Shuifei;

public interface ShuifeiService {

	public List<Shuifei> findAll();
	
	public int insertshuifei(Shuifei shuifei);
	
	public int updateshuifei(Shuifei shuifei);
	
	public int deleteshuifei(Shuifei shuifei);
	
	public List<Shuifei> findByID(Shuifei shuifei);
}
