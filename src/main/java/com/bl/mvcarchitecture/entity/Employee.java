package com.bl.mvcarchitecture.entity;

import java.sql.Date;

public class Employee {
	private String name;
	private Double salary;
	private Integer id;
	private Date start;

	public Employee(Integer id, String name, Double salary, Date start) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.start = start;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", start=" + start + "]";
	}

	

}
