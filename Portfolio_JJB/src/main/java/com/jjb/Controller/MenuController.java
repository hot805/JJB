
package com.jjb.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jjb.model.PageVO;
import com.jjb.util.MimeMediaUtil;
import com.jjb.util.UploadFileUtils;
import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.service.BoardService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private BoardService bservice;

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		System.out.println("메인임당");
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
	public void recipeGET() {
		System.out.println("레시피임당");
	}

	@RequestMapping(value = "/talk", method = RequestMethod.GET)
	public void talkGET() {
		System.out.println("토크임당");
	}

	@ResponseBody
	@RequestMapping(value = "/talk", method = RequestMethod.POST, produces = "text/palin;charset=utf-8")
	public ResponseEntity<String> talkPost(MultipartFile file, Model model) throws Exception {
		System.out.println("origianlName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		return new ResponseEntity<>(com.jjb.util.UploadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(),file.getBytes()),HttpStatus.CREATED);

	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public void noticeGET(Criteria cri, Model model, BoardVO board) throws Exception {
		System.out.println("공지사항임당 " + cri.toString());
		System.out.println(cri.getKeyword());
		String bsection = "";
		if (board.getSection() == null) {
			board.setSection("04-01");
		}

		if (board.getSection() == "04-01") {
			bsection = "tbl_board_notice";
		}
		Map<String, Object> ParamMap = new HashMap<>();
		ParamMap.put("cri", cri);
		ParamMap.put("bsection", bsection);

		int total = bservice.boardCount(ParamMap);
		System.out.println(total);
		PageVO pv = new PageVO(cri, total);

		System.out.println("리스트는 " + bservice.boardListPaging(ParamMap));

		model.addAttribute("list", bservice.boardListPaging(ParamMap));
		model.addAttribute("Page", pv);

	}

	@RequestMapping(value = "/notice/noticeDetail", method = RequestMethod.GET)
	public void noticeDetailGET(BoardVO board, Model model) throws Exception {
		System.out.println("공지사항 디테일쓰");

		// model.addAttribute("board",bservice.boardDetail(board));
	}

	@RequestMapping(value = "/chef", method = RequestMethod.GET)
	public void chefGET() {
		System.out.println("쉪임당");
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public void helpGET() {
		System.out.println("도움임당");
	}
}
