package com.jjb.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjb.model.Criteria;
import com.jjb.model.PageVO;
import com.jjb.model.UserVO;
import com.jjb.service.UserService;

@Controller
//@SessionAttributes({"userid","nickname"})//model에 넣을 때 세션에도 저장
@RequestMapping("/user")
public class UserController {
	@Resource
	private String uploadPath;
	
	@Autowired
	private UserService uservice;
	
	//로그인 페이지로 이동
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET() {
	}
	
	//로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(UserVO uservo, HttpSession session,RedirectAttributes redirect){
		UserVO user = null;
		try {
			user = uservice.login(uservo);
			session.setAttribute("userid", user.getUserid());
			
			//닉네임으로 db관리하면 안되는 이유 : 닉네임은 중복이 불가능하긴하나 수정이 가능하기때문에
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("qualify", user.getQualify());
			session.setAttribute("profileImg", user.getProfileImg());
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addAttribute("msg","1-1");
		}
		
		if(user == null) {
			redirect.addAttribute("msg","1-1");
		}else {
			redirect.addAttribute("msg","1-2");
		}
		return "redirect:/index";

		
	}
	
	//회원가입 페이지로 이동
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public void singUpGET() {
		
	}
	
	//회원가입
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String singUpPOST(UserVO user) throws Exception {
		System.out.println("회원가입 진입");
		uservice.signUp(user);
		return "redirect:../index";
	}
	
	//아이디 중복확인
	@RequestMapping(value="/checkID", method=RequestMethod.GET,produces = "application/json; charset=utf8")
	@ResponseBody//쉽게 말하면 return type변환
	public boolean checkID(String userid) throws Exception {
		System.out.println("checkID 진입" );
		String checkid = uservice.checkID(userid);
		if(checkid==null) {//null값이면 db에 저장된 값이 없음 -> 중복된 아이디가 없음
			return true;
		}else {//중복되는 아이디가 있음
			return false;
		}		
	}
	
	//닉네임 중복확인
	@RequestMapping(value="/checkNick", method=RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkNick(String nickname) throws Exception {
		System.out.println("checkNick 진입");
		return uservice.checkNick(nickname);	
	}
	
	//패스워드가 맞는지 확인
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
	
	//로그아웃
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.invalidate();
		System.out.println("여기");
		return "redirect:../index";
	}
	
	//관리 페이지로 이동
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public void manageGET() {
		
	}
	
	//개인정보 변경 페이지로 이동
	@RequestMapping(value="/changeInfo", method=RequestMethod.GET)
	public void changeInfoGET(HttpSession session,Model model) throws Exception {
		//System.out.println("changeInfo들왔네");
		String userid = (String)session.getAttribute("userid");
		UserVO user = uservice.InfoFromId(userid);
		System.out.println("dd = "+user);
		model.addAttribute("user",user);
		
	}
	
	//개인정보 변경
	@RequestMapping(value="/changeInfo",method=RequestMethod.POST)
	public void changeInfoPOST(UserVO user, HttpSession session) throws Exception{
		System.out.println("uservo는 "+user);
		int qualify = (int)session.getAttribute("qualify");
		
		if(qualify == 1) {
			uservice.changeChefInfo(user);
		}else {
			uservice.changeInfo(user);
		}
		
		session.setAttribute("nickname", user.getNickname());
		session.setAttribute("profileImg", user.getProfileImg());
	}
	
	//비밀번호 변경 페이지
	@RequestMapping(value="/changePw", method=RequestMethod.GET)
	public void changePwGET() {
		
	}
	
	//이미지 변경
	@RequestMapping(value="/changePw", method=RequestMethod.POST)
	@ResponseBody
	public void changePwPost(String newPw,HttpSession session) throws Exception{
		String userid = (String)session.getAttribute("userid");
		uservice.changePw(newPw, userid);
	}
	
	//회원탈퇴 페이지
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public void deleteUserGET() {
		
	}
	
	//회원탈퇴
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteUserPost(String password,HttpSession session) throws Exception{
		String userid = (String)session.getAttribute("userid");
		String reck = uservice.checkPW(userid);
		boolean result = false;
		if(reck.equals(password)) {
			uservice.deleteUser(userid);
			result = true;
		}else {		
			result =  false;
		}
		return result;
	}
	
	//관리자페이지 - 유저목록
	@RequestMapping(value="listUser", method=RequestMethod.GET)
	public String listUserGET(Model model,Criteria cri) throws Exception {
		int total =uservice.userCount();
		PageVO pv = new PageVO(cri, total); 
		model.addAttribute("list",uservice.userList(cri));
		model.addAttribute("Page",pv);
		return "admin/userList";
	}
	
	//관리자 - 쉐프권한 주기
	@ResponseBody
	@RequestMapping(value="grantUser", method=RequestMethod.POST)
	public void grantUserPOST(Model model, UserVO user) throws Exception {
		uservice.grantUser(user);
	}
	
	//관리자 - 쉐프권한 취소
	@ResponseBody
	@RequestMapping(value="revokeUser", method=RequestMethod.POST)
	public void revokeUserPOST(Model model, UserVO user) throws Exception {
		uservice.revokeUser(user);
	}
	
	//관리자 - 해당 아이디 탈퇴
	@ResponseBody
	@RequestMapping(value="deleteUser_admin", method=RequestMethod.POST)
	public void deleteUser_adminPOST(Model model, String userid) throws Exception {
		uservice.deleteUser(userid);
	}
	
	//이미지 이름 가져오기(profile이란 외부 폴더에서)
	@ResponseBody
	@RequestMapping(value = "/GetImgName", method = RequestMethod.POST, produces = "text/palin;charset=utf-8")
	public ResponseEntity<String> talkPost(MultipartFile file, Model model) throws Exception {
		System.out.println("origianlName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		return new ResponseEntity<>(com.jjb.util.UploadFileUtils.profileFile(uploadPath,file.getOriginalFilename(),file.getBytes()),HttpStatus.CREATED);

	}
}
