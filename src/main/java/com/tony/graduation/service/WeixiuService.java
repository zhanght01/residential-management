package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Weixiu;

public interface WeixiuService extends Serializable {
	
	public List<Weixiu> findAll();
	
	public List<Weixiu> findWeixiu();
	
	public List<Weixiu> findUnWeixiu();
	
	public int insertweixiu(Weixiu weixiu);

	public int updateweixiu(Weixiu weixiu);
	
	public int deleteweixiu(Weixiu weixiu);
}
