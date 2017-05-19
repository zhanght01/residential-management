package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.YezhuDao;
import com.tony.graduation.entity.Yezhu;
import com.tony.graduation.service.YezhuService;

@Service("yezhuService")
public class YezhuServiceImpl implements YezhuService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private YezhuDao yezhuDao;
	
	@Override
	public List<Yezhu> finAll() {
		return yezhuDao.findAll();
	}
	
	@Override
	public int insertyezhu(Yezhu yezhu) {
		return yezhuDao.insertyezhu(yezhu);
	}
	
	@Override
	public int updateyezhu(Yezhu yezhu) {
		return yezhuDao.updateyezhu(yezhu);
	}
	
	@Override
	public int deleteyezhu(Yezhu yezhu) {
		return yezhuDao.deleteyezhu(yezhu);
	}
}
