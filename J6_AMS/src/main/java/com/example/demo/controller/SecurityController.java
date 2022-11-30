package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Please Login!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Login Success!");
		return "security/login";
	}
	

	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Login Failed!");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String loginUnauthoried(Model model) {
		model.addAttribute("message", "Role is not matching!");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logOff(Model model) {
		model.addAttribute("message", "Logout Success!");
		return "security/login";
	}
}
