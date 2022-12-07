package j6.demo7.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import j6.demo7.entities.Authority;
import j6.demo7.repositories.AccountRepository;
import j6.demo7.repositories.AuthorityRepository;
import j6.demo7.repositories.RoleRepository;

@RestController
public class AuthorityRestController {
	
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private AuthorityRepository authorityRepo;
	
	@GetMapping("/api/authorities")
	public Map<String, Object> getAuthorities() {
		Map<String, Object> map = new HashMap<>();
		map.put("authorities", authorityRepo.findAll());
		map.put("accounts", accountRepo.findAll());
		map.put("roles", roleRepo.findAll());
		return map;
	}

	@PostMapping("/api/authorities")
	public Authority create(@RequestBody Authority authority) {
		return authorityRepo.save(authority);
	}

	@DeleteMapping("/api/authorities/{id}")
	public void create(@PathVariable("id") Integer id) {
		authorityRepo.deleteById(id);
	}
}
