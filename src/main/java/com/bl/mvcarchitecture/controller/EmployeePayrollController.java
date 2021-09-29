package com.bl.mvcarchitecture.controller;

import java.util.List;

import com.bl.mvcarchitecture.entity.Employee;
import com.bl.mvcarchitecture.service.EmployeePayrollService;
import com.bl.mvcarchitecture.util.EmployeePayrollView;

public class EmployeePayrollController {
	public static void main(String[] args) {
		EmployeePayrollView employeePayrollView = new EmployeePayrollView();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		boolean stop = true;
		do {
			int choice = employeePayrollView.getChoice();
			switch (choice) {
			case 1:
				List<Employee> employees = employeePayrollService.findAll();
				employeePayrollView.display(employees);
				break;
			case 2:
				stop = false;
			}
		} while (stop);
	}
}
