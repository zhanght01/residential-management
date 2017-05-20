package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Tousu;

public interface TousuService extends Serializable {
	public List<Tousu> findAll();
	
	public List<Tousu> findTousu();
	
	public List<Tousu> findUnTousu();
	
	public int inserttousu(Tousu tousu);
	
	public int updatetousu(Tousu tousu);
	
	public int deletetousu(Tousu tousu);
}
