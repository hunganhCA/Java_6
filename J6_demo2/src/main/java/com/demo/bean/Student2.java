package com.demo.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
	String name;
	Boolean gender = false;
	Double mark = 0.0;
	String email;
}
