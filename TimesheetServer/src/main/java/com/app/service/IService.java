package com.app.service;

import java.util.List;

import com.app.entity.Admin;
import com.app.entity.ELogbook;
import com.app.entity.EmpCred;
import com.app.entity.Employee;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;

public interface IService {
	public void saveEmployee(Employee theEmployee);
	public void saveEmpCred(EmpCred theEmpCred);
	public List<Employee> showAll();
	public void deleteById(int theId);
	public Employee findById(int theId);
	public EmpCred findCredById(String theId);
	public Employee findEmpByEmail(String theId);
	public Admin getAdmin(Integer id);
	public void createLeave(Leaves theleave);
	public List<TimeReport> getCustomDatesReport(String str);
	public List<ELogbook> getCustomTimeReport(int id);
	public List<Leaves> viewLeaveTypes();
	public void deleteLeavetype(String stri);
	public void approveTime(int id,String str);
	public void submitTime(int id,String str);
	public void addtosheet(ELogbook e);
}
