package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Zichan;

public interface ZichanDao extends Serializable {
	
	public List<Zichan> findAll();
	
	public int insertzichan(Zichan zichan);
	
	public int updatezichan(Zichan zichan);
	
	public int deletezichan(Zichan zichan);
}
