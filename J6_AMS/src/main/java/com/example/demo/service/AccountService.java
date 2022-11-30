package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired 
	AccountRepository accRe;
	public Account findByID(String id) {
		return accRe.findById(id).get();
	}
}
