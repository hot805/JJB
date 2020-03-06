package com.jjb.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.service.BoardService;
import com.jjb.service.ChefService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardService bservice;
	
	@Autowired
	private ChefService cservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public void index(Model model,Criteria cri,BoardVO board,String msg) throws Exception {
		if(cri.getPage()==null) {
			cri.setPage("/main");
		}	
		if(msg != null) {
			model.addAttribute("msg",msg);
		}
		model.addAttribute("list",bservice.RecentKeyword());
		model.addAttribute("cri",cri);
		model.addAttribute("board",board);
		
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main(Model model) throws Exception{
		System.out.println("main µé¾î¿È");
		model.addAttribute("List1", bservice.orderRecipe(0));
		model.addAttribute("List2", bservice.orderRecipe(1));
		model.addAttribute("List3", bservice.orderRecipe_like());
		
		
		
		return "board/main";
	}
	
	
	
}
