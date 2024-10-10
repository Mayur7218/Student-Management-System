package com.company;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		StudentManager sm=new StudentManager();
		
		while(true) {
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Filter Studsent by Course");
			System.out.println("4. Sort Student by Grades");
			System.out.println("5. Summarize");

			System.out.println();
			int input=sc.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Enter Id");
				int id=sc.nextInt();
				System.out.println("Enter Name");
				String name=sc.next();
				System.out.println("Enter Age");
				int age=sc.nextInt();
				System.out.println("Enter Grade");
				double grade=sc.nextDouble();
				System.out.println("Enter Course");
				String course=sc.next();
				sm.Add(id, name, age, grade, course);
				break;
			case 2:
				System.out.println("List of Students ->");
				sm.View();
				break;
			
			case 3:
				String c=sc.next();
				sm.Filter(c);
				break;
			case 4:
				String a=sc.next();
				sm.Sortgrade(a);
				break;
			case 5:
				sm.Summarize();
				break;
			}
			
		}
		
	}
}
