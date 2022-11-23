package com.demo.controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScopeContreller {
	@Autowired
	HttpServletRequest request; 
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/scope")
	public String index(Model model) throws Exception {
		model.addAttribute("a", "Model");
		request.setAttribute("b", "Request");
		session.setAttribute("c", "Session");
		servletContext.setAttribute("d", "ServletContext");
		return "scope/index";
	}
}
