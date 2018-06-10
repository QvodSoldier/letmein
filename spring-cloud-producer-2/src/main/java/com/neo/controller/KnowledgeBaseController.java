package com.neo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.UserContextHolder;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/kb")
public class KnowledgeBaseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CusumerService cusumerService;
	
	@RequestMapping("/test/{path}")
	public String testInvoke(@PathVariable("path") String path) {
		System.out.println("1-> "+UserContextHolder.currentUser().getUserId());
//		cusumerService.get();
//		System.out.println("3-> "+UserContextHolder.currentUser().getUserId());
		return "hello " + path;
	}
	
}
