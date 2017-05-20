package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tony.graduation.dao.WeixiuDao;
import com.tony.graduation.entity.Weixiu;
import com.tony.graduation.service.WeixiuService;

@Service("weixiuService")
public class WeixiuServiceImpl implements WeixiuService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private WeixiuDao weixiuDao;

	@Override
	public List<Weixiu> findAll() {
		return weixiuDao.findAll();
	}

	@Override
	public List<Weixiu> findWeixiu() {
		return weixiuDao.findWeixiu();
	}

	@Override
	public List<Weixiu> findUnWeixiu() {
		return weixiuDao.findUnWeixiu();
	}

	@Override
	public int insertweixiu(Weixiu weixiu) {
		return weixiuDao.insertweixiu(weixiu);
	}

	@Override
	public int updateweixiu(Weixiu weixiu) {
		return weixiuDao.updateweixiu(weixiu);
	}

	@Override
	public int deleteweixiu(Weixiu weixiu) {
		return weixiuDao.deleteweixiu(weixiu);
	}

}
