package com.tony.graduation.dao;

import java.io.Serializable;

import com.tony.graduation.entity.Userid;

public interface UseridDao extends Serializable {
	
	public Userid findID(Userid userid);
	
	public int updateID(Userid userid);
}
