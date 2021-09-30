package com.bl.mvcarchitecture.util;

import java.util.List;
import java.util.Scanner;

import com.bl.mvcarchitecture.entity.Employee;

public class EmployeePayrollView {

	public int getChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nEnter your choice: \n1.	Show the table. \n2.	Add to table. \n3.	Delete from table. \n4.	Update the table. \n5.	Exit. ");
		return sc.nextInt();
	}
	
	public int selectChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your choice: \n1.	Update name. \n2.	Update salary. \n3.	Update date.");
		return sc.nextInt();
	}

	public void display(List<Employee> employees) {
		System.out.println(employees);
		
	}
	
}
