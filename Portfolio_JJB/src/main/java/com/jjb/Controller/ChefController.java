package com.jjb.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.PageVO;
import com.jjb.service.ChefService;

@Controller
@RequestMapping("/chef")
public class ChefController {
	
	@Autowired 
	private ChefService cservice;
	//½¦ÇÁ ¸®½ºÆ®
	@RequestMapping(value="/chef", method=RequestMethod.GET)
	public String chefListGET(Model model, HttpSession session,Criteria cri,BoardVO board) throws Exception {
		String userid = (String)session.getAttribute("userid");
		int ordernum =0;
		
		int total = cservice.ChefCount();
		PageVO pv = new PageVO(cri, total);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", userid);
		paramMap.put("ordernum", ordernum);
		paramMap.put("cri",cri);
		
		List orderdate = cservice.ChefListPaging(paramMap);
		ordernum++;
		paramMap.replace("ordernum", ordernum);		
		List orderfollow = cservice.ChefListPaging(paramMap);
		ordernum++;
		paramMap.replace("ordernum", ordernum);
		List orderboard = cservice.ChefListPaging(paramMap);
		
		model.addAttribute("orderdate",orderdate);
		model.addAttribute("orderfollow",orderfollow);
		model.addAttribute("orderboard",orderboard);
		model.addAttribute("Page",pv);
		model.addAttribute("activeItem",board.getCategory());
		return "/board/chef";
	}
	//ÆÈ·Î¿ì Ãë¼Ò
	@ResponseBody
	@RequestMapping(value="/unfollow", method=RequestMethod.GET)
	public void unfollowGET(String chef_followed, HttpSession session) throws Exception {		
		Map<String, Object> follow = new HashMap<>();
		follow.put("chef_followed", chef_followed);
		follow.put("userid", session.getAttribute("userid"));
		
		cservice.unfollow(follow);
	}
	//ÆÈ·Î¿ì
	@ResponseBody
	@RequestMapping(value="/follow", method=RequestMethod.GET)
	public void followGET(String chef_followed, HttpSession session) throws Exception {
		Map<String, Object> follow = new HashMap<>();
		follow.put("chef_followed", chef_followed);
		follow.put("userid", session.getAttribute("userid"));
		
		cservice.follow(follow);
	}
	
}
