package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService proSer;
	@RequestMapping("/product/list")
	public String list(Model model,@RequestParam("cid") Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = proSer.fillByCateId(cid.get());
			model.addAttribute("items", list);
		}else {
			List<Product> list = proSer.fillAll();
			model.addAttribute("items", list);
		}
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id")Integer id) {
		Product item = proSer.fillById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
}



//Product pro = new Product();
//Category cate = new Category();
//cate.setId("1006");
//pro.setName("san pham 8");
//pro.setImage("1029.png");
//pro.setPrice(433d);
//pro.setCreateDate(new Date());
//pro.setCategory(cate);
//pro.setAvailable(true);
//proRe.save(pro);