package com.example.demo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studen {

	
	String name;
	Boolean gender = true;
	Double mark = 0.0;
}
