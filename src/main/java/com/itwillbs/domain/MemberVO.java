package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/*
 * tbl_member 테이블의 정보를 저장하는 도메인 객체
 */

@Data
public class MemberVO {
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	
	private Timestamp regdate;
	private Timestamp updatedate;
	private String enabled;
	
	private List<AuthVO> authList;
	
}
