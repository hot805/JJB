package com.jjb.service;

import java.util.List;
import java.util.Map;

import com.jjb.model.ChefVO;

public interface ChefService {
	//½¦ÇÁ ¸®½ºÆ®
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception;
	
	//½¦ÇÁ ÆäÀÌÂ¡
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception; 
	
	//½¦ÇÁ Ä«¿îÅÍ
	public int ChefCount() throws Exception;
	
	// ÆÈ·Î¿ì
	public void follow(Map<String, Object> follow) throws Exception;

	// ÆÈ·Î¿ì Ãë¼Ò
	public void unfollow(Map<String, Object> follow) throws Exception;
}
