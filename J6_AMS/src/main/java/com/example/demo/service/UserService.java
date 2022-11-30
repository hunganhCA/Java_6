package com.example.demo.service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	AccountService accSer;
	@Autowired
	BCryptPasswordEncoder pe;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account user = accSer.findByID(username);
			String password =user.getPassword();
			String[] role = user.getAuthorities().stream()
					.map(er->er.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(pe.encode(password)).roles(role).build();
		} catch (NoSuchElementException e) {
			throw new UsernameNotFoundException(username + "Not Found!");
		}
		
	}
	
}
