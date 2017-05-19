package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Yezhu;

public interface YezhuService extends Serializable{

	public List<Yezhu> finAll();
	
	public int insertyezhu(Yezhu yezhu);
	
	public int updateyezhu(Yezhu yezhu);
	
	public int deleteyezhu(Yezhu yezhu);
}
