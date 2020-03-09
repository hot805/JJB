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
	
	//½¦ÇÁ ¸®½ºÆ®
	@Override
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".cheflist",paramMap);
		return list;
	}

	//½¦ÇÁ ÆäÀÌÂ¡
	@Override
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception {
		List<ChefVO> list = sqlSession.selectList(namespace+".chefListPaging", paramMap);
		return list;
	}
	
	//½¦ÇÁ Ä«¿îÅÍ
	@Override
	public int ChefCount() throws Exception {
		int total = sqlSession.selectOne(namespace+".chefCount");
		return total;
	}
	
	//ÆÈ·Î¿ì
	@Override
	public void follow(Map<String, Object> follow) throws Exception {
		sqlSession.insert(namespace+".follow", follow);
	}
	
	//ÆÈ·Î¿ì Ãë¼Ò
	@Override
	public void unfollow(Map<String, Object> follow) throws Exception {
		sqlSession.delete(namespace+".unfollow", follow);
		
	}
	
	//ÆÈ·Î¿ì ¼ö °è»ê
	@Override
	public void follownum(Map<String, Object> follow) throws Exception {
		System.out.println(follow);
		sqlSession.update(namespace+".follownum", follow);
	}

}
