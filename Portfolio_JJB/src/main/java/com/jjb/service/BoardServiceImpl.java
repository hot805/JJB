package com.jjb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjb.mapper.BoardMapper;
import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bm;
	
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		// TODO Auto-generated method stub
		return bm.boardlist(name);
	}

	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.boardListPaging(paramMap);
	}

	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.boardCount(paramMap);
	}

	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.boardDetail(paramMap);
	}

	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.repBoardList(paramMap);
	}

	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.RepCount(paramMap);
	}

	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.repWrite(paramMap);
	}

	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.repModify(paramMap);
	}

	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.repDelete(paramMap);
		
	}

	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.boardWrite(paramMap);
	}

	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.boardModify(paramMap);
	}

	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.boardDelete(paramMap);
	}

	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.ModifyList(paramMap);
	}

	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.addViewCnt(paramMap);
		
	}

	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		// TODO Auto-generated method stub
		return bm.likeck(likeck);
	}

	@Override
	public void like(Map<String, Object> like) throws Exception {
		// TODO Auto-generated method stub
		bm.like(like);
	}

	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		// TODO Auto-generated method stub
		bm.unlike(like);
	}
	
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fffff"+followck);
		return bm.followck(followck);
	}

	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		// TODO Auto-generated method stub
		bm.searchKeyword(search);
	}

	@Override
	public List<String> RecentKeyword() throws Exception {
		// TODO Auto-generated method stub
		return bm.RecentKeyword();
	}

	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		// TODO Auto-generated method stub
		return bm.orderRecipe(order);
	}

	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		// TODO Auto-generated method stub
		return bm.orderRecipe_like();
	}

	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bm.likePaging(paramMap);
	}

	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.boardWriteBasic(paramMap);
	}

	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		bm.boardModifyBasic(paramMap);;
	}

	@Override
	public void help_answer(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		bm.help_answer(board);
	}


}
