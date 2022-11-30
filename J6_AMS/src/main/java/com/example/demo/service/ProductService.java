package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
ProductRepository proRe;
	public List<Product> fillAll(){
		return proRe.findAll();
	}
	
	public Product  fillById(Integer id){
		return proRe.findById(id).get();
	}

	public List<Product> fillByCateId(String cid) {
		return proRe.findByCateId(cid);
	}
}
