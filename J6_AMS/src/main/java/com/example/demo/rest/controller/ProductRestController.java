package com.example.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	@Autowired
	ProductService proSer;
	
	@GetMapping("{id}")
	public Product GetOne(@PathVariable("id") Integer id) {
		return proSer.fillById(id);
	}
	
	@GetMapping()
	public List<Product> GetAll() {
		return proSer.fillAll();
	}
	
}
