package com.demo.controller;


import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class StudentContreller {
	@Autowired
	HttpServletRequest request; 
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/student")
	public String student(Model model,
			@RequestParam("index")Optional<Integer> index) throws Exception {
			ObjectMapper mapper = new ObjectMapper();
			File path = ResourceUtils.getFile("classpath:com/demo/bean/student.json");
			TypeReference<List<Student2>> typeReference = new TypeReference<List<Student2>>() {};
			List<Student2> list = mapper.readValue(path, typeReference);
			int i = index.orElse(0);
			model.addAttribute("n", i);
			model.addAttribute("sv", list.get(i));
			return "scope/student";
	}
}
