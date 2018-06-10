package com.neo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("customer")
public interface CusumerService {

	@GetMapping("/get")
	public String get();
}
