package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.ParkDao;
import com.tony.graduation.entity.Park;
import com.tony.graduation.service.ParkService;

@Service("parkService")
public class ParkServiceImpl implements ParkService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ParkDao parkDao;
	@Override
	public List<Park> findPark() {
		return parkDao.findPark();
	}

	@Override
	public List<Park> findUnPark() {
		return parkDao.findUnPark();
	}

	@Override
	public List<Park> findAllPark() {
		return parkDao.findAllPark();
	}

	@Override
	public int insertPark(Park park) {
		return parkDao.insertPark(park);
	}

	@Override
	public int updatePark(Park park) {
		return parkDao.updatePark(park);
	}

	@Override
	public int deletePark(Park park) {
		return parkDao.deletePark(park);
	}

}
