package com.itwillbs.domain;

import lombok.Data;

/*
 * tbl_member_auth 테이블의 정보를 저장하는 도메인 객체
 */

@Data
public class AuthVO {
	
	private String userid;
	private String auth;
	
}
