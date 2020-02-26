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
		System.out.println("공지사항임당 "+cri.toString());
		System.out.println(cri.getKeyword());
		String bsection="";
		String location="";
		System.out.println("나는 "+board.getSection());
		System.out.println(board);
		
		if(cri.getKeyword() != null) {
			Map<String,Object> search = new HashMap<>();
			search.put("keyword", cri.getKeyword());
			search.put("userid", session.getAttribute("userid"));
			bservice.searchKeyword(search);
		}
		
		if(board.getSection().equals("B4-01")) {
			bsection = "tbl_board_notice";
			location="/board/notice";
		}
		
		else if(board.getSection().equals("B4-02")||board.getSection().equals("B4-03")||board.getSection().equals("B4-04")) {
			bsection = "tbl_board_event";
			location="/board/noticeEvent";
		}
		
		else if(board.getSection().equals("B3-01")) {
			bsection = "tbl_talk";
			location="/board/talk";
		}
		
		else if(board.getSection().equals("B2-01")) {
			bsection = "tbl_recipe";
			location="/board/recipe";
			cri.setAmount(12);
		}
			
		else if (board.getSection().equals("B6-01")) {
			bsection = "tbl_help";
			location = "board/help";
		}
		
		Map<String,Object> ParamMap = new HashMap<>();
		ParamMap.put("cri", cri);
		ParamMap.put("board", board);
		ParamMap.put("bsection",bsection);
		ParamMap.put("bsNum",board.getSection());
		ParamMap.put("sessionid", session.getAttribute("userid"));
		
		int total = bservice.boardCount(ParamMap);
		System.out.println(total);
		PageVO pv = new PageVO(cri, total); 
		
		System.out.println("리스트는 "+bservice.boardListPaging(ParamMap));
		
		if(board.getSection().equals("B2-01") && board.getOrderno() == 03) {
			System.out.println("좋아요3333");
			System.out.println(bservice.likePaging(ParamMap));
			model.addAttribute("list",bservice.likePaging(ParamMap));
		}else {
			model.addAttribute("list",bservice.boardListPaging(ParamMap));
		}
		model.addAttribute("Page",pv);
		
		return location;
	}

	// 게시판 작성
	@ResponseBody
	@RequestMapping(value = "/write", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public void boardWritePOST(BoardVO board, HttpSession session) throws Exception {
		System.out.println("게시판 글 작성");
		System.out.println("fff" + board);
		String userid = (String) session.getAttribute("userid");
		String nickname = (String) session.getAttribute("nickname");
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

		bservice.boardWrite(paramMap);

	}

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

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", board.getBno());
		paramMap.put("bsection", bsection);

		bservice.boardDelete(paramMap);
	}

	// 공지사항 내부
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boardDetailGET(Criteria cri, BoardVO board, Model model,HttpSession session) throws Exception {
		System.out.println("공지사항 디테일쓰");
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
		// String bsNum = reboard.getSection();
		System.out.println(reboard.getSection());
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
		
	@ResponseBody
	@RequestMapping(value="/unlike", method=RequestMethod.GET)
	public void unlikeGET(BoardVO board, HttpSession session) throws Exception {
		System.out.println("좋아요 취소 돌입 "+board);		
		
		Map<String, Object> like = new HashMap<>();
		like.put("board", board);
		like.put("userid", session.getAttribute("userid"));
		
		bservice.unlike(like);
	}
	
	@ResponseBody
	@RequestMapping(value="/like", method=RequestMethod.GET)
	public void likeGET(BoardVO board, HttpSession session) throws Exception {
		System.out.println("좋아요 돌입 "+board);
		
		Map<String, Object> like = new HashMap<>();
		like.put("board", board);
		like.put("userid", session.getAttribute("userid"));
		
		bservice.like(like);
	}
}
