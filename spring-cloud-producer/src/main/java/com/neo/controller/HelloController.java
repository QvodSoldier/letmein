package com.neo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

//    @Autowired
//    private KnowledgeBaseService knowledgeBaseService;
    
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+", this is first service.";
    }
    
//    @GetMapping("/get")
//    public String get() {
//    	System.out.println("2->" + UserContextHolder.currentUser().getUserId());
//        return "hello  get, this is first messge";
//    }
}