package com.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OperatorContreller {
	
	@GetMapping("/demo/operator")
	public String operator(Model model) {
			model.addAttribute("x", 5);
			model.addAttribute("y", 7);
			return "scope/operator";
	}
}
