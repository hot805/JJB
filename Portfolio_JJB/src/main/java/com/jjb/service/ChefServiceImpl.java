package com.jjb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.mapper.ChefMapper;
import com.jjb.model.ChefVO;

@Service
public class ChefServiceImpl implements ChefService{
	@Autowired
	private ChefMapper cm;
	
	@Override
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return cm.ChefList(paramMap);
	}

	@Override
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return cm.ChefListPaging(paramMap);
	}

	@Override
	public int ChefCount() throws Exception {
		// TODO Auto-generated method stub
		return cm.ChefCount();
	}
	
	@Transactional
	@Override
	public void follow(Map<String, Object> follow) throws Exception {
		cm.follow(follow);
		cm.follownum(follow);
	}
	
	@Transactional
	@Override
	public void unfollow(Map<String, Object> follow) throws Exception {
		cm.unfollow(follow);
		cm.follownum(follow);
	}
}
