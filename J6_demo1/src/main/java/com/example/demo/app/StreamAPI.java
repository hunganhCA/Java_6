 package com.example.demo.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.demo.beans.Studen;

public class StreamAPI {
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
		double average = list.stream()
				.mapToDouble(sv->sv.getMark())
				.average().getAsDouble();
				System.out.println("average: "+average);
		
		double sum = list.stream()
				.mapToDouble(sv->sv.getMark())
				.sum();
		System.out.println("sum: "+sum);
		
		double min_marks = list.stream()
				.mapToDouble(sv->sv.getMark())
				.min().getAsDouble();
		System.out.println("min_marks: "+min_marks);
		
		boolean allPass = list.stream()
				.allMatch(sv->sv.getMark()>=5);
		System.out.println("all_pass: "+allPass);
		
		Studen min_sv = list.stream()
				.reduce(list.get(0),(min,sv)->sv.getMark()<min.getMark()?sv:min);
		System.out.println("min_sv: "+min_sv.getName());
	}

	private static void demo3() {
		List<Studen> result =  list.stream()
				.filter(sv->sv.getMark()>=5)
				.peek(sv->sv.setName(sv.getName().toUpperCase()))
				.collect(Collectors.toList()); 
		result.forEach(sv->{
			System.out.println(">>Name: "+sv.getName());
			System.out.println("Mark: "+sv.getMark());
			System.out.println();
		});
	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1,9,4,5,7,6);
		List<Double> result = (List<Double>) list.stream()
				.filter(n -> n%2==0)
				.map(n->Math.sqrt(n))
				.peek(d->System.out.println(d))
				.collect(Collectors.toList()); 
		
	}

	private static void demo1() {
		
		
	List<Integer> list = Arrays.asList(1,9,4,5,7,6);
	list.stream().forEach(n->{
		System.out.println(n);
	});
	}

}
