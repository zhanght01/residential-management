package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.FangkeDao;
import com.tony.graduation.entity.Fangke;
import com.tony.graduation.service.FangkeService;

@Service("fangkeService")
public class FangkeServiceImpl implements FangkeService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private FangkeDao fangkeDao;
	
	@Override
	public List<Fangke> findFinish() {
		return fangkeDao.findFinish();
	}

	@Override
	public List<Fangke> findUnFinish() {
		return fangkeDao.findUnFinish();
	}

	@Override
	public int insertFangke(Fangke fangke) {
		return fangkeDao.insertFangke(fangke);
	}

	@Override
	public int updateFangke(Fangke fangke) {
		return fangkeDao.updateFangke(fangke);
	}

	@Override
	public int deleteFangke(Fangke fangke) {
		return fangkeDao.deleteFangke(fangke);
	}
	
}
