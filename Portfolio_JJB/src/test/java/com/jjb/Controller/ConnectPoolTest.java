package com.jjb.Controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//컴파일 할때 SpringJUnit4ClassRunner 클래스와 같이 컴파일 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context가 어디있는지 인지 시켜주는 것

public class ConnectPoolTest {
	@Autowired//DataSource dataSource = new DataSource(); 역할
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Test//junit test를 통해 실행하기 위해서 붙여주는 것
	public void testConnection() {
		try (
				SqlSession session = sqlSessionFactory.openSession();
				Connection con = dataSource.getConnection();
				){
			System.out.println("세션="+session);
			System.out.println("커넥="+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
