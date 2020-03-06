package com.jjb.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jjb.model.BoardVO;
import com.jjb.model.RepBoardVO;
import com.jjb.service.BoardService;
import com.jjb.util.MimeMediaUtil;

@Controller
@RequestMapping("/talk")
public class TalkController {
	
	@Resource
	private String uploadPath;
	
	@Autowired BoardService bservice;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String talkListGET() throws Exception{
		
		return "/board/talk";
	}
	
	@RequestMapping(value="/insertImg", method = RequestMethod.GET)
	public String insertImgGET() throws Exception{
		System.out.println("insertImg 돌입");
		return "/board/talkInsertImg";
	}
	
	@RequestMapping(value="/talkWrite", method = RequestMethod.GET)
	public String talkWriteGET(Model model) throws Exception{
		System.out.println("talkWrite 돌입");
		model.addAttribute("part","write");
		
		return "/board/talkWrite";
	}
	
	@RequestMapping(value="/talkModify", method = RequestMethod.GET)
	public String talkModifyGET(Model model,BoardVO board) throws Exception{
		System.out.println("talkModify 돌입");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bsection", "tbl_talk");
		paramMap.put("bno", board.getBno());
		
		BoardVO vo = bservice.ModifyList(paramMap);
		model.addAttribute("BoardVO", vo);
		
		return "/board/talkModify";
	}
	
	@ResponseBody
	@RequestMapping(value="/talkDelete",method = RequestMethod.GET)
	//public String talkDeleteGET(BoardVO board,Model model,RedirectAttributes redirect){
	public void talkDeleteGET(BoardVO board) throws Exception{
		System.out.println("토크 삭제");
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bsection", "tbl_talk");
		paramMap.put("bno", board.getBno());
		bservice.boardDelete(paramMap);
	
	}
	
	@ResponseBody
	@RequestMapping(value="/talkWrite", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String talkWritePOST(HttpSession session,String content) throws Exception{
		System.out.println("talkWrite POST 돌입");
		System.out.println(content);
		String nickname = (String)session.getAttribute("nickname");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("content", content);
		paramMap.put("nickname", nickname);
		
		
		return content;
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetImgName", method = RequestMethod.POST, produces = "text/palin;charset=utf-8")
	public ResponseEntity<String> talkPost(MultipartFile file, Model model) throws Exception {
		System.out.println("origianlName: " + file.getOriginalFilename());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());

		return new ResponseEntity<>(com.jjb.util.UploadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(),file.getBytes()),HttpStatus.CREATED);

	}
	
	@ResponseBody
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		File file = new File(uploadPath+fileName);
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		System.out.println("FILE NAME : "+fileName);
		System.out.println("FILE : "+file);
		
		try {
			String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MimeMediaUtil.getMediaType(formatName);
			HttpHeaders header = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			//header.add("content-Type", Files.probeContentType(file.toPath()));
			if(mType != null) {
				header.add("Content-Type", Files.probeContentType(file.toPath()));
			}else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				header.add("Content-DisPosition", "attachment);fileName=\""+
						new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header, HttpStatus.OK);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		System.out.println("이미지 삭제");
		String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MimeMediaUtil.getMediaType(formatName);
		
		if(mType != null) {
			String front = fileName.substring(0,12);
			String end = fileName.substring(14);
			new File(uploadPath+ (front+end).replace('/', File.separatorChar)).delete();
		}
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	
}
