package com.jjb.Controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjb.mapper.BoardMapper;
import com.jjb.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)//컴파일 할때 SpringJUnit4ClassRunner 클래스와 같이 컴파일 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context가 어디있는지 인지 시켜주는 것
public class BoardTest {
	@Autowired
	private BoardMapper bm;
	
	@Test
	public void testSelect() throws Exception{
		String name = "tbl_board_notice";
		List<BoardVO> board = bm.boardlist(name);
		System.out.println(board);
	}

}
