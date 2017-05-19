package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Fangke;

public interface FangkeService extends Serializable {
	
	public List<Fangke> findFinish();
	
	public List<Fangke> findUnFinish();
	
	public int insertFangke(Fangke fangke);
	
	public int updateFangke(Fangke fangke);
	
	public int deleteFangke(Fangke fangke);
}
