package com.bl.mvcarchitecture.controller;

import java.util.List;
import java.util.Scanner;

import com.bl.mvcarchitecture.dao.EmployeePayrollDAO;
import com.bl.mvcarchitecture.entity.Employee;
import com.bl.mvcarchitecture.service.EmployeePayrollService;
import com.bl.mvcarchitecture.util.EmployeePayrollView;

public class EmployeePayrollController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeePayrollView employeePayrollView = new EmployeePayrollView();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		EmployeePayrollDAO employeePayrollDAO = new EmployeePayrollDAO();
		boolean stop = true;
		do {
			int choice = employeePayrollView.getChoice();
			switch (choice) {
			case 1:
				List<Employee> employees = employeePayrollService.findAll();
				employeePayrollView.display(employees);
				break;
			case 2:
				System.out.println("Enter ID: ");
				int id = sc.nextInt();
				System.out.println("Enter Name: ");
				String name = sc.next();
				System.out.println("Enter Salary: ");
				double salary = sc.nextDouble();
				System.out.println("Enter Date: ");
				String start = sc.next();
				try {
					int insertTable = employeePayrollDAO.insertTable(id, name, salary, start);
					if (insertTable > 0) {
						System.out.println("Data has been inserted successfully");
					} else {
						System.out.println("Data has not been inserted");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter ID: ");
				int id1 = sc.nextInt();
				try {
					int deleteTable = employeePayrollDAO.deleteTable(id1);
					if (deleteTable > 0) {
						System.out.println("Data has been deleted successfully");
					} else {
						System.out.println("Data has not been deleted");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				int selectChoice = employeePayrollView.selectChoice();
				switch (selectChoice) {
				case 1:
					System.out.println("Enter the name: ");
					String name1 = sc.next();
					System.out.println("Enter the id: ");
					int id11 = sc.nextInt();
					try {
						int updateTable = employeePayrollDAO.updateTableName(name1, id11);
						if (updateTable > 0) {
							System.out.println("Data has been updated successfully");
						} else {
							System.out.println("Data has not been updated");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter the salary: ");
					double salary1 = sc.nextDouble();
					System.out.println("Enter the id: ");
					int id111 = sc.nextInt();
					try {
						int updateTable = employeePayrollDAO.updateTableSalary(salary1, id111);
						if (updateTable > 0) {
							System.out.println("Data has been updated successfully");
						} else {
							System.out.println("Data has not been updated");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the name: ");
					String start1 = sc.next();
					System.out.println("Enter the id: ");
					int id1111 = sc.nextInt();
					try {
						int updateTable = employeePayrollDAO.updateTableDate(start1, id1111);
						if (updateTable > 0) {
							System.out.println("Data has been updated successfully");
						} else {
							System.out.println("Data has not been updated");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				break;
			case 5:
				stop = false;
				break;
			}
		} while (stop);
	}
}
