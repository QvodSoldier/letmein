package com.neo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-producer")
public interface KnowledgeBaseService {

	@RequestMapping("/kb/test/{path}")
	public String testInvoke(@PathVariable("path") String path);
}
