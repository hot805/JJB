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
	
	@RequestMapping(value="/chef", method=RequestMethod.GET)
	public String chefListGET(Model model, HttpSession session,Criteria cri,BoardVO board) throws Exception {
		System.out.println("chef 입성");
		String userid = (String)session.getAttribute("userid");
		int ordernum =0;
		
		int total = cservice.ChefCount();
		PageVO pv = new PageVO(cri, total);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", userid);
		paramMap.put("ordernum", ordernum);
		paramMap.put("cri",cri);
		
		List orderdate = cservice.ChefListPaging(paramMap);
		System.out.println(orderdate);
		ordernum++;
		paramMap.replace("ordernum", ordernum);		
		List orderfollow = cservice.ChefListPaging(paramMap);
		System.out.println(orderfollow);
		ordernum++;
		paramMap.replace("ordernum", ordernum);
		List orderboard = cservice.ChefListPaging(paramMap);
		System.out.println(orderboard);
		
		model.addAttribute("orderdate",orderdate);
		model.addAttribute("orderfollow",orderfollow);
		model.addAttribute("orderboard",orderboard);
		model.addAttribute("Page",pv);
		model.addAttribute("activeItem",board.getCategory());
		return "/board/chef";
	}
	
	@ResponseBody
	@RequestMapping(value="/unfollow", method=RequestMethod.GET)
	public void unfollowGET(String chef_followed, HttpSession session) throws Exception {
		System.out.println("팔로우 취소 돌입 "+chef_followed);		
		
		Map<String, Object> follow = new HashMap<>();
		follow.put("chef_followed", chef_followed);
		follow.put("userid", session.getAttribute("userid"));
		
		cservice.unfollow(follow);
	}
	
	@ResponseBody
	@RequestMapping(value="/follow", method=RequestMethod.GET)
	public void followGET(String chef_followed, HttpSession session) throws Exception {
		System.out.println("팔로우 돌입 "+chef_followed);
		
		Map<String, Object> follow = new HashMap<>();
		follow.put("chef_followed", chef_followed);
		follow.put("userid", session.getAttribute("userid"));
		
		cservice.follow(follow);
	}
	
}
