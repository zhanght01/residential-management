package com.tony.graduation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.ShuifeiDao;
import com.tony.graduation.entity.Shuifei;
import com.tony.graduation.service.ShuifeiService;

@Service("shuifei")
public class ShuifeiServiceImpl implements ShuifeiService {

	@Resource
	private ShuifeiDao shuifeidao;
	
	@Override
	public List<Shuifei> findAll() {
		return shuifeidao.findAll();
	}

	@Override
	public int insertshuifei(Shuifei shuifei) {
		return shuifeidao.insertshuifei(shuifei);
	}

	@Override
	public int updateshuifei(Shuifei shuifei) {
		return shuifeidao.updateshuifei(shuifei);
	}

	@Override
	public int deleteshuifei(Shuifei shuifei) {
		return shuifeidao.deleteshuifei(shuifei);
	}

	@Override
	public List<Shuifei> findByID(Shuifei shuifei) {
		return shuifeidao.findByID(shuifei);
	}

}
