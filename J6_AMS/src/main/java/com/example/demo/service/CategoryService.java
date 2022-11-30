package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
@Autowired
CategoryRepository cateRe;
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateRe.findAll();
	}

}
