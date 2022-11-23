package com.demo.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	String name;
	Boolean gender = false;
	Double mark;
	Contact contact;
	List<String> subject;
}
