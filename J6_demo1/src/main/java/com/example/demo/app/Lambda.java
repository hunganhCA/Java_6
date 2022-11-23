package com.example.demo.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.example.demo.beans.Studen;

public class Lambda {
	
	static List<Studen> list = Arrays.asList(
			new Studen("Nguyen Phi Hung", true, 9.5),
			new Studen("Nguyen Kieu Trinh", false, 8.5),
			new Studen("Nguyen Tuan Dung", true, 6.5),
			new Studen("Nguyen Hung Anh", true, 4.5),
			new Studen("Nguyen Hai Anh", true, 7.5)
			);

	public static void main(String[] args) {
		demo4();

	} 

	private static void demo4() {
		 
		Demo4Inter o =x ->System.out.println(x);
		o.m1(2022);
		
	}

	private static void demo3() {
		
		Collections.sort(list,(sv1,sv2)-> sv1.getMark().compareTo(sv2.getMark()));
		list.forEach(sv ->{ 
			System.out.println(">>Name: "+sv.getName());
			System.out.println("Mark: "+sv.getMark());
			System.out.println();
		});
	}

	private static void demo2() {
	
		list.forEach(sv ->{
			System.out.println(">>Name: "+sv.getName());
			System.out.println(">>Gender: "+sv.getGender());
			System.out.println("Mark: "+sv.getMark());
		});
	}

	private static void demo1() {
	
		
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		list.forEach(h ->System.out.println(h)); 
	}
	
	@FunctionalInterface
	interface Demo4Inter{
		void m1(int x);
		default void m2() {}
		public static void m3() {} 
	}

}
