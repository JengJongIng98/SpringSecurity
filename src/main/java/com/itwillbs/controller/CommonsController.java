package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonsController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommonsController.class);
	
	// /accessErr 동작 처리
	@RequestMapping(value = "/accessErr",method = RequestMethod.GET)
	public void accessErr(Authentication auth) throws Exception{
		logger.info(" accessErr() 실행 ");
		
		logger.info("auth : "+auth);
		
		logger.info(" /accessErr.jsp 뷰페이지 연결 ");
	}
	
	// /customLogin 동작처리
	@GetMapping(value = "/customLogin")
	public void myLogin() throws Exception{
		logger.info(" myLogin() 실행 ");
		
		logger.info(" /customLogin.jsp 뷰페이지 이동 ");
	}
	
	// /customLogout 동작처리
	@GetMapping(value = "/customLogout")
	public void myLogout() throws Exception{
		logger.info(" 로그아웃 처리 실행 ");
		logger.info(" /customLogout.jsp 뷰페이지 이동 ");
		
//		return "redirect:/sample/all";
	}
	
}
