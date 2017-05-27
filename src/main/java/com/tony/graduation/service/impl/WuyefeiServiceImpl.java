package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.WuyefeiDao;
import com.tony.graduation.entity.Wuyefei;
import com.tony.graduation.service.WuyefeiService;

@Service("wuyefei")
public class WuyefeiServiceImpl implements WuyefeiService {

	@Resource
	private WuyefeiDao wuyefeiDao;
	
	@Override
	public List<Wuyefei> findAll() {
		return wuyefeiDao.findAll();
	}

	@Override
	public int insertwuyefei(Wuyefei wuyefei) {
		return wuyefeiDao.insertwuyefei(wuyefei);
	}

	@Override
	public int updatewuyefei(Wuyefei wuyefei) {
		return wuyefeiDao.updatewuyefei(wuyefei);
	}

	@Override
	public int deletewuyefei(Wuyefei wuyefei) {
		return wuyefeiDao.deletewuyefei(wuyefei);
	}
	
}
