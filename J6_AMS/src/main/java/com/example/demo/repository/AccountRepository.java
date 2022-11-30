package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

}
