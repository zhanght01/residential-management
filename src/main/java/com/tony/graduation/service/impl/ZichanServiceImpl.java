package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.ZichanDao;
import com.tony.graduation.entity.Zichan;
import com.tony.graduation.service.ZichanService;

@Service("zichan")
public class ZichanServiceImpl implements ZichanService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ZichanDao zichanDao;
	@Override
	public List<Zichan> findAll() {
		return zichanDao.findAll();
	}

	@Override
	public int insertzichan(Zichan zichan) {
		return zichanDao.insertzichan(zichan);
	}

	@Override
	public int updatezichan(Zichan zichan) {
		return zichanDao.updatezichan(zichan);
	}

	@Override
	public int deletezichan(Zichan zichan) {
		return zichanDao.deletezichan(zichan);
	}
	
}
