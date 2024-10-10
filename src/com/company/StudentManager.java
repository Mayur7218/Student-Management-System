package com.company;
import java.util.*;
import java.util.stream.Collectors;
public class StudentManager {
	List<Student> list=new ArrayList<>();
	
	public void Add(int id,String name,int age,double grade,String course) {
		if(list.stream().anyMatch(i->i.getid()==id)) {
			System.out.println("Student already exists with this "+id);
		}
		
		try {
			Student newStudent=new Student(id,name,age,grade,course);
			list.add(newStudent);
			System.out.println("Succesfully Added new Student");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void View() {
		if(list.isEmpty()) {
			System.out.println("No student is present");
			return;
		}
		try {
			list.forEach(s->System.out.println(s));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void Filter(String course) {
		List<Student> filterList=list.stream()
				.filter(s->s.getcourse().equalsIgnoreCase(course))
				.collect(Collectors.toList());
		
		if(filterList.isEmpty()) {
			System.out.println("No Student with this "+course+" is found");
		}
		else {
			filterList.forEach(s-> System.out.println(s));
		}
	}
	public void Sortgrade(String order) {
		if(list.isEmpty()) {
			System.out.println("No student is present");
			return;
		}
		if(order.equalsIgnoreCase("desc")) {
			list.sort(Comparator.comparingDouble(Student::getgrade).reversed());
		}
		else {
			list.sort(Comparator.comparingDouble(Student::getgrade));	
			}
		list.forEach(System.out::println);
		
	}
	public void Summarize() {
		
		if(list.isEmpty()) {
			System.out.println("No student is present");
			return;
		}
		
		DoubleSummaryStatistics ageStats = list.stream()
	            .filter(Objects::nonNull)
	            .mapToDouble(Student::getage)
	            .summaryStatistics();
	    
	    DoubleSummaryStatistics gradeStats = list.stream()
	            .filter(Objects::nonNull)
	            .mapToDouble(Student::getgrade)
	            .summaryStatistics();

	    System.out.println("Average Age: " + ageStats.getAverage());
	    System.out.println("Average Grade: " + gradeStats.getAverage());
	    
		
		Map<String,Long> map=list.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(Student::getcourse,Collectors.counting()));
		System.out.println("Student per course");
		map.forEach((course,count)->System.out.println(course+" : "+count));
	}
	
}
