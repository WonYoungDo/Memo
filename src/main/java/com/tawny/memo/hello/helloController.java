package com.tawny.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/hello/jsp")
	public String helloJsp() {
		return "hello/hello";
	}
	
	
}
