package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Yezhu;

public interface YezhuDao extends Serializable {
	
	/**
	 * 查询所有业主信息
	 * @return
	 */
	public List<Yezhu> findAll();
	
	/**
	 * 插入业主信息
	 * @param yezhu
	 * @return
	 */
	public int insertyezhu(Yezhu yezhu);
	
	/**
	 * 修改业主信息
	 * @param yezhu
	 * @return
	 */
	public int updateyezhu(Yezhu yezhu);
	
	/**
	 * 删除业主信息
	 * @param yezhu
	 * @return
	 */
	public int deleteyezhu(Yezhu yezhu);
}
