package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.TousuDao;
import com.tony.graduation.entity.Tousu;
import com.tony.graduation.service.TousuService;

@Service("tousuService")
public class TousuServiceImpl implements TousuService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private TousuDao tousuDao;
	
	@Override
	public List<Tousu> findAll() {
		return tousuDao.findAll();
	}

	@Override
	public List<Tousu> findTousu() {
		return tousuDao.findTousu();
	}

	@Override
	public List<Tousu> findUnTousu() {
		return tousuDao.findUnTousu();
	}

	@Override
	public int inserttousu(Tousu tousu) {
		return tousuDao.inserttousu(tousu);
	}

	@Override
	public int updatetousu(Tousu tousu) {
		return tousuDao.updatetousu(tousu);
	}

	@Override
	public int deletetousu(Tousu tousu) {
		return tousuDao.deletetousu(tousu);
	}
	
}
