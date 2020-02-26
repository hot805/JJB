package com.jjb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.model.ChefVO;

@Repository
public class ChefMapperImpl implements ChefMapper{
	
	@Autowired
	private SqlSession sqlSession;	
	private static final String namespace="com.jjb.mapper.ChefMapper";
	
	@Override
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".cheflist",paramMap);
		return list;
	}

	@Override
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception {
		List<ChefVO> list = sqlSession.selectList(namespace+".chefListPaging", paramMap);
		return list;
	}

	@Override
	public int ChefCount() throws Exception {
		int total = sqlSession.selectOne(namespace+".chefCount");
		return total;
	}

	@Override
	public void follow(Map<String, Object> follow) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".follow", follow);
	}

	@Override
	public void unfollow(Map<String, Object> follow) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".unfollow", follow);
		
	}

	@Override
	public void follownum(Map<String, Object> follow) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ÆÈ·Î¿ì È®ÀÎ");
		System.out.println(follow);
		sqlSession.update(namespace+".follownum", follow);
	}

}
