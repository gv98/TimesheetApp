package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface IService {
	public void saveEmployee(Employee theEmployee);
	public List<Employee> showAll();
	public void deleteById(int theId);
	public Employee findById(int theId);
}
