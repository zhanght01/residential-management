package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Weixiu;

public interface WeixiuDao extends Serializable {
	/**
	 * 返回所有数据
	 * @return
	 */
	public List<Weixiu> findAll();
	/**
	 * 返回已经维修完成的数据
	 * @return
	 */
	public List<Weixiu> findWeixiu();
	/**
	 * 返回还没有维修的数据
	 * @return
	 */
	public List<Weixiu> findUnWeixiu();
	/**
	 * 插入新的维修数据
	 * @param weixiu
	 * @return
	 */
	public int insertweixiu(Weixiu weixiu);
	/**
	 * 更新维修数据
	 * 主要用于变更状态
	 * @param weixiu
	 * @return
	 */
	public int updateweixiu(Weixiu weixiu);
	/**
	 * 删除维修数据
	 * @param weixiu
	 * @return
	 */
	public int deleteweixiu(Weixiu weixiu);
}
