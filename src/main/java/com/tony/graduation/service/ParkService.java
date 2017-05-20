package com.tony.graduation.service;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Park;

public interface ParkService extends Serializable {
	
	public List<Park> findPark();
	
	public List<Park> findUnPark();
	
	public List<Park> findAllPark();
	
	public int insertPark(Park park);
	
	public int updatePark(Park park);
	
	public int deletePark(Park park);
}
