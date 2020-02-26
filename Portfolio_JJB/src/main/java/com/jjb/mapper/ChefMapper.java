package com.jjb.mapper;

import java.util.List;
import java.util.Map;

import com.jjb.model.ChefVO;

public interface ChefMapper {
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception;
	
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception;
	
	public int ChefCount() throws Exception;

	// ÆÈ·Î¿ì
	public void follow(Map<String, Object> follow) throws Exception;

	// ÆÈ·Î¿ì Ãë¼Ò
	public void unfollow(Map<String, Object> follow) throws Exception;

	// ÆÈ·Î¿ì ¼ö °è»ê
	public void follownum(Map<String, Object> follow) throws Exception;
}
