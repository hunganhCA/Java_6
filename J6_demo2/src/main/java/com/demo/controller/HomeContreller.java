package com.demo.controller;


import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.bean.Student;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeContreller {
	@GetMapping("/home/index")
	public String hello(Model model) throws Exception {
		model.addAttribute("message", "Xin chao");
		ObjectMapper mapper = new ObjectMapper();
		String path = "/Users/nguyenthihien/Downloads/demo_thymeleaf/src/main/resources/static/student.json";
		Student student = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv", student);
		return "home/index";
	}
}
