package com.student.service.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main { 

	@GetMapping("/")
	public String helloWorld(){
		return "layout";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
	