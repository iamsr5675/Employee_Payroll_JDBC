package com.bl.mvcarchitecture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
				/*
				 * System.out.println(result.getInt("id") + "  " + result.getString("name") +
				 * "  " + result.getDouble("salary") + "  " + result.getDate("start"));
				 */
				Integer id = result.getInt("id");
				String name = result.getString("name");
				Double salary = result.getDouble("salary");
				Date start = result.getDate("start");
				employees.add(new Employee(id, name, salary, start));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public int insertTable(int id, String name, double salary, String start) {
		String insertSQL = "insert into employee_payroll values(?,?,?,?)";
		int result = 0;
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, salary);
			preparedStatement.setString(4, start);

			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int deleteTable(int id) {
		String deleteSql = "DELETE FROM employee_payroll WHERE id = ?";
		int result = 0;
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);

			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public int updateTableName(String name, int id) {
		int result = 0;
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE employee_payroll SET name = ?  WHERE id = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateTableSalary(double salary, int id) {
		int result = 0;
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE employee_payroll SET salary = ?  WHERE id = ?");
			preparedStatement.setDouble(1, salary);
			preparedStatement.setInt(2, id);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateTableDate(String start, int id) {
		int result = 0;
		try {
			Connection connection = EmployeePayrollConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE employee_payroll SET start = ?  WHERE id = ?");
			preparedStatement.setString(1, start);
			preparedStatement.setInt(2, id);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
