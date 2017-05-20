package com.tony.graduation.dao;

import java.io.Serializable;
import java.util.List;

import com.tony.graduation.entity.Park;

public interface ParkDao extends Serializable {

	/**
	 * 查找所有已经被占用的停车位
	 * @return
	 */
	public List<Park> findPark();
	/**
	 * 查找所有还没有被占用的停车位
	 * @return
	 */
	public List<Park> findUnPark();
	/**
	 * 查找所有停车位
	 * @return
	 */
	public List<Park> findAllPark();
	/**
	 * 插入新的停车位信息
	 * @param park
	 * @return
	 */
	public int insertPark(Park park);
	/**
	 * 删除停车位信息
	 * @param park
	 * @return
	 */
	public int deletePark(Park park);
	/**
	 * 更新停车位信息
	 * 主要用于车位被占用时更新状态
	 * @param park
	 * @return
	 */
	public int updatePark(Park park);
}
