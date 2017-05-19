package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Fangke;

public interface FangkeDao extends Serializable {
	/**
	 * 查询已完成访客的信息
	 * @return
	 */
	public List<Fangke> findFinish();
	/**
	 * 查询未完成访客的信息
	 * @return
	 */
	public List<Fangke> findUnFinish();
	
	/**
	 * 添加访客信息
	 * @param fangke
	 * @return
	 */
	public int insertFangke(Fangke fangke);
	/**
	 * 更新访客状态信息
	 * @param fangke
	 * @return
	 */
	public int updateFangke(Fangke fangke);
	/**
	 * 删除录入错误的访客信息
	 * @param fangke
	 * @return
	 */
	public int deleteFangke(Fangke fangke);
}
