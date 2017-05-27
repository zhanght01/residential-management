package com.tony.graduation.service;

import java.io.Serializable;

import com.tony.graduation.entity.Userid;

public interface UseridService extends Serializable {
	public Userid findID(Userid userid);
	
	public int updateID(Userid userid);
}
