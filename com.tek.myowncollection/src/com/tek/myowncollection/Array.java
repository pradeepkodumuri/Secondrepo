package com.tek.myowncollection;

import java.util.ArrayList;
import java.util.List;

public class Array {

	public static void main(String[] args) {
		List<Employee> employee=new ArrayList<Employee>();
		Employee e1=new Employee();
		e1.setName("raj");
		e1.setId(10);
		e1.setAddress("kmm");
		Employee e2=new Employee();
		e2.setName("rajeeeesh");
		e2.setId(20);
		e2.setAddress("vij");
		
		employee.add(e1);
		employee.add(e2);
		
		for(Employee xyz: employee) {
			System.out.println(xyz);
			
		}
		
	}

}
