package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sample/")
//@Log4J
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// http://localhost:8088/sample/all
	@GetMapping(value = "/all")
	public void doAll() {
		logger.info(" doAll() 실행! ");
	}
	
	// http://localhost:8088/sample/member
	@RequestMapping(value = "/member",method = RequestMethod.GET)
	public void doMember() {
		logger.info(" doMember() 실행! ");
	}
	
	// http://localhost:8088/sample/admin
	@GetMapping(value = "/admin")
	public void doAdmin() {
		logger.info(" doAdmin() 실행! ");
	}
	
}
