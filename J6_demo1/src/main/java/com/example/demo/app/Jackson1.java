package com.example.demo.app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

	public static void main(String[] args) throws IOException {
		demo2();

	}

	private static void demo2() throws IOException {
String json="/Users/nguyenthihien/eclipse-workspace/J6d1/src/main/resources/student2.json";
		
		ObjectMapper mapper= new ObjectMapper(); 
		JsonNode students = mapper.readTree(new File(json ));
		students.iterator().forEachRemaining(student->{
			System.out.println(">>Subject: "+student.get("name").asText());
		});
	}

	private static void demo1() throws IOException {
		

		String json="/Users/nguyenthihien/eclipse-workspace/J6d1/src/main/resources/student.json";
		
		ObjectMapper mapper= new ObjectMapper(); 
		JsonNode student = mapper.readTree(new File(json ));
		System.out.println(">>Name: "+student.get("name").asText());
		System.out.println(">>Marks: "+student.get("marks").asDouble());
		System.out.println(">>Email: "+student.get("contact").get("email").asText());
		System.out.println(">>Gender: "+student.get("gender").asBoolean());
		System.out.println(">>Phone: "+student.findValue("phone").asText());
			student.get("subjec").iterator().forEachRemaining(subjec->{
				System.out.println(">>Subject: "+subjec.asText());
			});
	}

}
