package com.jjb.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.service.BoardService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	private BoardService bservice;
	
	//레시피 리스트
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String recipeListGET() throws Exception{
		System.out.println("레시피");
		return "board/recipe";
	}
	
	@RequestMapping(value="/recipeWrite",method=RequestMethod.GET)
	public String recipeWriteGET() throws Exception{
		System.out.println("레시피 작성");
		return "board/recipeWrite";
	}
	
	@RequestMapping(value="/recipeModify",method=RequestMethod.GET)
	public String recipeModifyGET(Model model,BoardVO board) throws Exception{
		System.out.println("레시피 수정");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bsection", "tbl_recipe");
		paramMap.put("bno", board.getBno());
		
		BoardVO vo = bservice.ModifyList(paramMap);
		model.addAttribute("BoardVO", vo);
		
		return "board/recipeModify";
	}
	
}
