package com.company;
import java.util.*;
public class Student {
	
	int id;
	String name;
	int age;
	double grade;
	String course;
	
	public Student(int id,String name,int age,double grade,String course) {
		if(name.isEmpty() ||name.length()> 50) {
			throw new IllegalArgumentException("Invalid Name");
		}
		if(age<18 || age>25) {
			throw new IllegalArgumentException("Invalid Age");
		}
		if(grade <0.0 || grade >4.0) {
			throw new IllegalArgumentException("Invalid Grade");
		}
		if(course==null || course.isEmpty()) {
			throw new IllegalArgumentException("Invalid Course");
		}
		
		this.id=id;
		this.name=name;
		this.age=age;
		this.grade=grade;
		this.course=course;
	}

		
		public int getid() {
			return id;
		}
		public String getname() {
			return name;
		}
		public int getage() {
			return age;
		}
		public double getgrade() {
			return grade;
		}
		public String getcourse() {
			return course;
		}
		
		
		public String toString() {
		    return String.format("ID: %d, Name: %s, Age: %d, Grade: %.2f, Course: %s",
		            id, name, age, grade, course);
		}
	

}
