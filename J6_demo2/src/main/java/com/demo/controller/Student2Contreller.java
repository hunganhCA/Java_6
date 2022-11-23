package com.demo.controller;


import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Student2Contreller {
	
	@GetMapping("/student/list")
	public String list(Model model,
			@RequestParam("index") Optional<Integer> index) throws Exception {
			File path = new ClassPathResource("/static/students.json").getFile();
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {};
			List<Student> students = mapper.readValue(path, typeReference);
			
			model.addAttribute("sv", students.get(index.orElse(0)));
			model.addAttribute("dssv", students);
			model.addAttribute("now", new Date());
			return "scope/list_student";
	}
}
