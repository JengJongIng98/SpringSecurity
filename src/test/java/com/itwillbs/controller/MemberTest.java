package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					"file:src/main/webapp/WEB-INF/spring/security-context.xml"}
		)
public class MemberTest {
	
	@Inject
	private DataSource ds;
	
	// 암호화 처리 객체
	@Inject
	private PasswordEncoder pwEncoder;
	
	
	@Inject
	private MemberDAO mdao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	
	//@Test
	public void insertMemberTest() throws Exception {
		
		for(int i=0;i<100;i++) {
		// 1.2. 디비연결
		Connection con = ds.getConnection();
		
		// 3. sql 구문 & pstmt 객체
		String sql = "insert into tbl_member (userid,userpw,username,useremail) "
					+ " values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3-1. ???
		// 비밀번호 (암호화)
		pstmt.setString(2, pwEncoder.encode("pw"+i));
		
		if(i<80) {
			pstmt.setString(1, "user"+i);
			pstmt.setString(3, "사용자"+i);
			pstmt.setString(4, "user"+i+"@itwillbs.co.kr");
		}else if(i<90){
			pstmt.setString(1, "manager"+i);
			pstmt.setString(3, "매니저"+i);
			pstmt.setString(4, "manager"+i+"@itwillbs.co.kr");
		}else {
			pstmt.setString(1, "admin"+i);
			pstmt.setString(3, "관리자"+i);
			pstmt.setString(4, "admin"+i+"@itwillbs.co.kr");
		}
		
		// 4. sql 실행
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		}
	}
	
	//@Test
	public void insertAuthMemberTest() throws Exception {
		
		for(int i=0;i<100;i++) {
		// 1.2. 디비연결
		Connection con = ds.getConnection();
		
		// 3. sql 구문 & pstmt 객체
		String sql = "insert into tbl_member_auth (userid,auth) "
					+ " values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3-1. ???
		
		if(i<80) {
			pstmt.setString(1, "user"+i);
			pstmt.setString(2, "ROLE_USER");
		}else if(i<90){
			pstmt.setString(1, "manager"+i);
			pstmt.setString(2, "ROLE_MANAGER");
		}else {
			pstmt.setString(1, "admin"+i);
			pstmt.setString(2, "ROLE_ADMIN");
		}
		
		// 4. sql 실행
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		}
	}
	
	@Test
	public void testMemberAuth() throws Exception{
		MemberVO resultVO = mdao.getMemberAuth("admin90");
		
		logger.info("resultVO : {}",resultVO);
	}
	
}
