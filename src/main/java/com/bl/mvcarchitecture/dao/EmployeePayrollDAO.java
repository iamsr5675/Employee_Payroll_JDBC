package com.bl.mvcarchitecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bl.mvcarchitecture.entity.Employee;
import com.bl.mvcarchitecture.util.EmployeePayrollConnection;

public class EmployeePayrollDAO {
	

	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee_payroll;";
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
			/*	System.out.println(result.getInt("id") + "  " + result.getString("name") + "  "
						+ result.getDouble("salary") + "  " + result.getDate("start"));*/
				String name = result.getString("name");
				Double salary = result.getDouble("salary");
				employees.add(new Employee(name, salary));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
