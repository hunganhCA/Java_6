package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello.th")
	public String hello(Model model) {
		model.addAttribute("message", "Truong <b>FPT</b>");
		return "hello";
	}
	
}
