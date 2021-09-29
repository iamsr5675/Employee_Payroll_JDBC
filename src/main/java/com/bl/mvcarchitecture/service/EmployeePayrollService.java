package com.bl.mvcarchitecture.service;

import java.util.List;

import com.bl.mvcarchitecture.dao.EmployeePayrollDAO;
import com.bl.mvcarchitecture.entity.Employee;

public class EmployeePayrollService {
	EmployeePayrollDAO employeePayrollDao = new EmployeePayrollDAO();

	public List<Employee> findAll() {

		return employeePayrollDao.findAll();
	}

}
