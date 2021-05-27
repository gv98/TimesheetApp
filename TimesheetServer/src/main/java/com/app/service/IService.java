package com.app.service;

import java.util.List;

import com.app.entity.Admin;
import com.app.entity.Employee;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;

public interface IService {
	public void saveEmployee(Employee theEmployee);
	public List<Employee> showAll();
	public void deleteById(int theId);
	public Employee findById(int theId);
	public Admin getAdmin(Integer id);
	public void createLeave(Leaves theleave);
	public List<TimeReport> getCustomDatesReport(String str);
}
