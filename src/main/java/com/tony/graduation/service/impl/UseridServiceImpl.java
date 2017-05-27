package com.tony.graduation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.UseridDao;
import com.tony.graduation.entity.Userid;
import com.tony.graduation.service.UseridService;

@Service("useridService")
public class UseridServiceImpl implements UseridService {

	@Resource
	private UseridDao useridDao;
	
	@Override
	public Userid findID(Userid userid) {
		return useridDao.findID(userid);
	}

	@Override
	public int updateID(Userid userid) {
		return useridDao.updateID(userid);
	}
	
}
