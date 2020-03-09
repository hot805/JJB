package com.jjb.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.PageVO;
import com.jjb.model.RepBoardVO;
import com.jjb.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bservice;


	// 공지사항
	@RequestMapping(value="/")
	public String noticeBoardGET( BoardVO board, Model model,Criteria cri,HttpSession session) throws Exception{
		String bsection="";
		String location="";	
		if(cri.getKeyword() != null) {
			Map<String,Object> search = new HashMap<>();
			search.put("keyword", cri.getKeyword());
			search.put("userid", session.getAttribute("userid"));
			bservice.searchKeyword(search);
		}
		if(board.getSection().equals("B4-01")) {
			bsection = "tbl_board_notice";
			location="/board/notice";
		}else if(board.getSection().equals("B4-02")||board.getSection().equals("B4-03")||board.getSection().equals("B4-04")) {
			bsection = "tbl_board_event";
			location="/board/noticeEvent";
		}else if(board.getSection().equals("B3-01")) {
			bsection = "tbl_talk";
			location="/board/talk";
		}else if(board.getSection().equals("B2-01")) {
			bsection = "tbl_recipe";
			location="/board/recipe";
			cri.setAmount(12);
		}else if (board.getSection().equals("B6-01")) {
			bsection = "tbl_help";
			location = "board/help";
		}
		Map<String,Object> ParamMap = new HashMap<>();
		ParamMap.put("cri", cri);
		ParamMap.put("board", board);
		ParamMap.put("bsection",bsection);
		ParamMap.put("bsNum",board.getSection());
		ParamMap.put("sessionid", session.getAttribute("userid"));
		ParamMap.put("sessionqualify", session.getAttribute("qualify"));
		
		int total = bservice.boardCount(ParamMap);
		PageVO pv = new PageVO(cri, total); 
	
		if(board.getSection().equals("B2-01") && board.getOrderno() == 03) {
			model.addAttribute("list",bservice.likePaging(ParamMap));
		}else {
			model.addAttribute("list",bservice.boardListPaging(ParamMap));
		}
		model.addAttribute("Page",pv);
		
		return location;
	}
	
	//글작성 페이지로 이동
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String boardWriteGET(BoardVO board, Model model) throws Exception{
		String section = board.getSection();
		String location="";
		if(section.equals("B4-01") || section.equals("B6-01")) {
			location = "board/boardWrite";
		}else {
			location = "board/boardWrite_Event";
		}
		System.out.println(section);
		model.addAttribute("section",section);
		
		return location;
	}
	
	//글작성 기본페이지로 이동(공지사항, 이벤트, 문의사항)
	@RequestMapping(value="/writeBasic",method=RequestMethod.GET)
	public String writeBasicGET(BoardVO board, Model model) throws Exception{
		System.out.println("writeBasic 돌입");
		String section = board.getSection();
		String location="";
		if(section.equals("B4-01") || section.equals("B6-01")) {
			location = "board/boardWrite";
		}else {
			location = "board/boardWrite_Event";
		}
		System.out.println(board);
		model.addAttribute("section",section);
		
		return location;
	}
	
	//글변경 기본페이지로 이동(공지사항, 이벤트, 문의사항)
	@RequestMapping(value="/modifyBasic",method=RequestMethod.GET)
	public String modifyBasicGET(BoardVO board, Model model) throws Exception{
		System.out.println("modifyBasic 돌입");
		String section = board.getSection();
		String location="";
		if(section.equals("B4-01") || section.equals("B6-01")) {
			location = "board/boardModify";
		}else {
			location = "board/boardModify_Event";
			System.out.println("dd");
		}
		System.out.println(board);
		model.addAttribute("board",board);
		
		return location;
	}
	
	//글작성 기본(공지사항, 이벤트, 문의사항)
	@RequestMapping(value = "/writeBasic", method = RequestMethod.POST)
	public String boardWriteBasicPOST(BoardVO board, HttpSession session,RedirectAttributes redirect){
		System.out.println("board : "+board);
		String bsection = "";
		String fail ="";
		String success ="";
		if (board.getSection().equals("B4-01")) {
			bsection = "tbl_board_notice";
			fail="4-1";
			success="4-2";
		}
		else if (board.getSection().equals("B6-01")) {
			bsection = "tbl_help";
			fail="6-1";
			success="6-2";
		}
		else if (board.getSection().equals("B4-02") || board.getSection().equals("B4-03") || board.getSection().equals("B4-04") ) {
			bsection = "tbl_board_Event";
			fail="4-21";
			success="4-22";
		}
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board", board);
		paramMap.put("userid", session.getAttribute("userid"));
		paramMap.put("nickname", session.getAttribute("nickname"));
		paramMap.put("profileImg", session.getAttribute("profileImg"));
		paramMap.put("bsection",bsection);
		
		try {
			bservice.boardWriteBasic(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addAttribute("msg",fail);
		}
		redirect.addAttribute("msg",success);
		return "redirect:/index";
	}
	
	//글변경 기본(공지사항, 이벤트, 문의사항)
	@RequestMapping(value="/modifyBasic",method=RequestMethod.POST)
	public String modifyBasicPOST(BoardVO board, Model model,RedirectAttributes redirect, HttpSession session){
		System.out.println("modifyBasicPOST");
		System.out.println("board : "+board);
		String bsection = "";
		String fail ="";
		String success ="";
		if (board.getSection().equals("B4-01")) {
			bsection = "tbl_board_notice";
			fail="4-3";
			success="4-4";
		}
		else if (board.getSection().equals("B6-01")) {
			bsection = "tbl_help";
			fail="6-3";
			success="6-4";
		}
		else if (board.getSection().equals("B4-02") || board.getSection().equals("B4-03") || board.getSection().equals("B4-04") ) {
			bsection = "tbl_board_Event";
			fail="4-23";
			success="4-24";
		}
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board", board);
		paramMap.put("bsection",bsection);
		
		try {
			bservice.boardModifyBasic(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addAttribute("msg",fail);
		}
		redirect.addAttribute("msg",success);
		return "redirect:/index";
	}

	// 게시판 글작성(레시피, 토크)
	@ResponseBody
	@RequestMapping(value = "/write", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public void boardWritePOST(BoardVO board, HttpSession session) throws Exception {
		String userid = (String) session.getAttribute("userid");
		String nickname = (String) session.getAttribute("nickname");
		String profileImg = (String) session.getAttribute("profileImg");
		String bsection = "";
		if (board.getSection().equals("B3-01")) {
			bsection = "tbl_talk";
		}
		else if (board.getSection().equals("B2-01")) {
			bsection = "tbl_recipe";		
		}

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board", board);
		paramMap.put("userid", userid);
		paramMap.put("nickname", nickname);
		paramMap.put("bsection", bsection);
		paramMap.put("bsNum", board.getSection());
		paramMap.put("profileImg", profileImg);

		bservice.boardWrite(paramMap);
	}
	
	// 게시판 글변경(레시피, 토크)
	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public void boardModifyPOST(BoardVO board) throws Exception {
		System.out.println("게시판 글 수정");
		String bsection = "";
		if (board.getSection().equals("B3-01")) {
			bsection = "tbl_talk";
		}
		
		else if (board.getSection().equals("B2-01")) {
			bsection = "tbl_recipe";
		}
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("board", board);
		paramMap.put("bsection", bsection);
		System.out.println("수정 paramMap : "+paramMap);
		bservice.boardModify(paramMap);
	}
	
	//글삭제 게시판 전체
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void boardDeletePOST(BoardVO board) throws Exception {
		System.out.println("게시판 글 삭제");
		String bsection = "";
		if (board.getSection().equals("B3-01")) {
			bsection = "tbl_talk";
		}
		
		else if (board.getSection().equals("B2-01")) {
			bsection = "tbl_recipe";
		}
		
		else if (board.getSection().equals("B4-01")) {
			bsection = "tbl_board_notice";
		}
		
		else if (board.getSection().equals("B6-01")) {
			bsection = "tbl_help";
		}
		
		else if (board.getSection().equals("B4-02") || board.getSection().equals("B4-03") || board.getSection().equals("B4-04") ) {
			bsection = "tbl_board_event";
		}

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", board.getBno());
		paramMap.put("bsection", bsection);

		bservice.boardDelete(paramMap);
	}

	// 공지사항 내부
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetailGET(Criteria cri, BoardVO board, Model model,HttpSession session) throws Exception {
		System.out.println("공지사항 디테일");
		cri.setAmount(15);
		System.out.println(board);
		String bsNum = board.getSection();
		String rsNum = board.getSection().replaceFirst("B", "R");
		String rsection = "";
		String bsection = "";
		String result = "";

		if (bsNum.equals("B4-01")) {
			bsection = "tbl_board_notice";
			rsection = "tbl_notice_rep";
			result = "board/detail";
		}

		else if (bsNum.equals("B4-02") || bsNum.equals("B4-03") || bsNum.equals("B4-04")) {
			bsection = "tbl_board_event";
			rsection = "tbl_event_rep";
			result = "board/detail";
		}

		else if (bsNum.equals("B3-01")) {
			bsection = "tbl_talk";
			rsection = "tbl_talk_rep";
			result = "board/talkDetail";
		}
		
		else if (bsNum.equals("B2-01")) {
			bsection = "tbl_recipe";
			rsection = "tbl_recipe_rep";
			result = "board/detail";
			
			Map<String, Object> likeck = new HashMap<>();
			likeck.put("userid", session.getAttribute("userid"));
			likeck.put("board", board);
			
			model.addAttribute("likeck",bservice.likeck(likeck));
			model.addAttribute("followck",bservice.followck(likeck));
		}		
		
		Map<String, Object> viewcnt = new HashMap<>();
		viewcnt.put("bsection", bsection);
		viewcnt.put("bno", board.getBno());
		
		if(!bsNum.equals("B3-01")) {
			bservice.addViewCnt(viewcnt);
		}
		

		Map<String, Object> ParamMap = new HashMap<>();
		ParamMap.put("cri", cri);
		ParamMap.put("rsection", rsection);
		ParamMap.put("bsNum", bsNum);
		ParamMap.put("bsection", bsection);
		ParamMap.put("rsNum", rsNum);
		ParamMap.put("bno", board.getBno());

		System.out.println(ParamMap);
		int total = bservice.RepCount(ParamMap);
		System.out.println(total);
		PageVO pv = new PageVO(cri, total);

		System.out.println("댓글리스트는 " + bservice.repBoardList(ParamMap));
		model.addAttribute("list", bservice.repBoardList(ParamMap));
		model.addAttribute("Page", pv);
		model.addAttribute("board", bservice.boardDetail(ParamMap));

		return result;
	}

	// 댓글 작성
	@RequestMapping(value = "/repWrite", method = RequestMethod.POST)
	@ResponseBody
	public void repWritePOST(RepBoardVO reboard) throws Exception {
		System.out.println("notice 댓글 작성");
		String rsNum = reboard.getSection().replaceFirst("B", "R");
		String rsection = "";
		if (rsNum.equals("R4-01")) {
			rsection = "tbl_notice_rep";
		}
		else if (rsNum.equals("R4-02") || rsNum.equals("R4-03") || rsNum.equals("R4-04")) {
			rsection = "tbl_event_rep";
		}

		else if (rsNum.equals("R3-01")) {
			rsection = "tbl_talk_rep";
		}
		
		else if (rsNum.equals("R2-01")) {
			rsection = "tbl_recipe_rep";
		}

		Map<String, Object> ParamMap = new HashMap<>();
		ParamMap.put("reboard", reboard);
		ParamMap.put("rsNum", rsNum);
		ParamMap.put("rsection", rsection);

		System.out.println(ParamMap);
		bservice.repWrite(ParamMap);
	}

	// 댓글 수정
	@RequestMapping(value = "/repModify", method = RequestMethod.POST)
	@ResponseBody
	public void repModifyPOST(RepBoardVO reboard) throws Exception {
		System.out.println("notice 댓글 수정");

		String rsNum = reboard.getSection().replaceFirst("B", "R");
		String rsection = "";
		if (rsNum.equals("R4-01")) {
			rsection = "tbl_notice_rep";
		}
		else if (rsNum.equals("R4-02") || rsNum.equals("R4-03") || rsNum.equals("R4-04")) {
			rsection = "tbl_event_rep";
		}
		else if (rsNum.equals("R3-01")) {
			rsection = "tbl_talk_rep";
		}
		else if (rsNum.equals("R2-01")) {
			rsection = "tbl_recipe_rep";
		}

		Map<String, Object> ParamMap = new HashMap<>();
		ParamMap.put("reboard", reboard);
		ParamMap.put("rsection", rsection);

		System.out.println(ParamMap);
		bservice.repModify(ParamMap);
	}

	// 댓글 삭제
	@RequestMapping(value = "/repDelete", method = RequestMethod.POST)
	@ResponseBody
	public void repDeletePOST(RepBoardVO reboard) throws Exception {
		System.out.println("notice 댓글 삭제");

		String rsection = "";
		if (reboard.getSection().equals("B4-01")) {
			rsection = "tbl_notice_rep";
		}

		else if (reboard.getSection().equals("B4-02") || reboard.getSection().equals("B4-03")
				|| reboard.getSection().equals("B4-04")) {
			rsection = "tbl_event_rep";
		}
		else if (reboard.getSection().equals("B3-01")) {
			rsection = "tbl_talk_rep";
		}
		
		else if (reboard.getSection().equals("B3-01")) {
			rsection = "tbl_recipe_rep";
		}

		Map<String, Object> ParamMap = new HashMap<>();
		ParamMap.put("rno", reboard.getRno());
		ParamMap.put("rsection", rsection);

		bservice.repDelete(ParamMap);
	}
	
	//좋아요 취소
	@ResponseBody
	@RequestMapping(value="/unlike", method=RequestMethod.GET)
	public void unlikeGET(BoardVO board, HttpSession session) throws Exception {
		Map<String, Object> like = new HashMap<>();
		like.put("board", board);
		like.put("userid", session.getAttribute("userid"));
		
		bservice.unlike(like);
	}
	
	//좋아요
	@ResponseBody
	@RequestMapping(value="/like", method=RequestMethod.GET)
	public void likeGET(BoardVO board, HttpSession session) throws Exception {
		Map<String, Object> like = new HashMap<>();
		like.put("board", board);
		like.put("userid", session.getAttribute("userid"));
		
		bservice.like(like);
	}
	
	//이미지 삽입 팝업창 페이지 이동
	@RequestMapping(value="/insertImg", method = RequestMethod.GET)
	public String insertImgGET() throws Exception{
		System.out.println("insertImg 돌입");
		return "/board/eventInsertImg";
	}
	
	//문의사항 답변
	@ResponseBody
	@RequestMapping(value="/help_answer", method = RequestMethod.POST)
	public void help_answerGET(BoardVO board) throws Exception{
		System.out.println("help_answer 돌입");
		System.out.println(board);
		bservice.help_answer(board);
	}
}
