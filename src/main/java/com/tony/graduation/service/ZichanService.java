package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Zichan;

public interface ZichanService extends Serializable {
	
	public List<Zichan> findAll();
	
	public int insertzichan(Zichan zichan);
	
	public int updatezichan(Zichan zichan);
	
	public int deletezichan(Zichan zichan);
}
