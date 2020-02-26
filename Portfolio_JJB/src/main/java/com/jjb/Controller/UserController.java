package com.jjb.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjb.model.UserVO;
import com.jjb.service.UserService;

@Controller
//@SessionAttributes({"userid","nickname"})//model에 넣을 때 세션에도 저장
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService uservice;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(UserVO uservo, HttpSession session,RedirectAttributes redirect){
		UserVO user;
		try {
			user = uservice.login(uservo);
			System.out.println(user);
			//model.addAttribute("userid",user.getUserid());
			//model.addAttribute("nickname",user.getNickname());
			session.setAttribute("userid", user.getUserid());
			
			//닉네임으로 db관리하면 안되는 이유 : 닉네임은 중복이 불가능하긴하나 수정이 가능하기때문에
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("qualify", user.getQualify() );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			redirect.addAttribute("msg","1");
		}
		return "redirect:/index";

		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public void singUpGET() {
		
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String singUpPOST(UserVO user) throws Exception {
		System.out.println("회원가입 진입");
		System.out.println("유저는 "+user.toString());
		uservice.signUp(user);
		return "redirect:../index";
		//return "redirect:user/login";
	}
	
	@RequestMapping(value="/checkID", method=RequestMethod.GET,produces = "application/json; charset=utf8")
	@ResponseBody//쉽게 말하면 return type변환
	public boolean checkID(String userid) throws Exception {
		System.out.println("checkID 진입" );
		String checkid = uservice.checkID(userid);
		System.out.println(checkid);
		if(checkid==null) {//null값이면 db에 저장된 값이 없음 -> 중복된 아이디가 없음
			return true;
		}else {//중복되는 아이디가 있음
			return false;
		}		
	}
	
	@RequestMapping(value="/checkNick", method=RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkNick(String nickname) throws Exception {
		System.out.println("checkNick 진입");
		return uservice.checkNick(nickname);	
	}
	
	
	@RequestMapping(value="/checkPw", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkPw(String password,HttpSession session) throws Exception{
		System.out.println("체크페스워드 : "+password);
		String userid = (String)session.getAttribute("userid");
		System.out.println("유저아이디"+userid);
		String rePw = uservice.checkPW(userid);
		System.out.println("return 패스워드 : "+rePw);
		
		
		return true;
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		System.out.println("여기");
		return "redirect:../index";
	}
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public void manageGET() {
		
	}
	
	@RequestMapping(value="/changeInfo", method=RequestMethod.GET)
	public void changeInfoGET(HttpSession session,Model model) throws Exception {
		//System.out.println("changeInfo들왔네");
		String userid = (String)session.getAttribute("userid");
		UserVO user = uservice.InfoFromId(userid);
		System.out.println("dd = "+user);
		model.addAttribute("user",user);
		
	}
	
	@RequestMapping(value="/changeInfo",method=RequestMethod.POST)
	public void changeInfoPOST(UserVO user, HttpSession session) throws Exception{
		System.out.println("uservo는 "+user);
		uservice.changeInfo(user);
		session.setAttribute("nickname", user.getNickname());	
	}
	
	
	@RequestMapping(value="/changePw", method=RequestMethod.GET)
	public void changePwGET() {
		
	}
	
	@RequestMapping(value="/changePw", method=RequestMethod.POST)
	@ResponseBody
	public void changePwPost(String newPw,HttpSession session) throws Exception{
		String userid = (String)session.getAttribute("userid");
		uservice.changePw(newPw, userid);
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public void deleteUserGET() {
		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteUserPost(String password,HttpSession session) throws Exception{
		System.out.println("pass ="+password);
		String userid = (String)session.getAttribute("userid");
		String reck = uservice.checkPW(userid);
		boolean result = false;
		System.out.println(reck);
		if(reck.equals(password)) {
			uservice.deleteUser(userid);
			result = true;
		}else {		
			System.out.println("false : "+reck);
			result =  false;
		}
		return result;
	}
}
