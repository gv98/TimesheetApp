package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.dao.EmployeeRepository;
import com.app.dao.LeaveRepository;
import com.app.dao.TimeRepository;
import com.app.entity.Admin;
import com.app.entity.Employee;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;

@Service
public class ServiceImpl implements IService {

	private EmployeeRepository employeeRepository;
	private AdminRepository adminRepository;
	private LeaveRepository leaveRepository;
	private TimeRepository timeRepository;
	
	@Autowired
	public ServiceImpl(EmployeeRepository employeeRepository,AdminRepository adminRepository,
			LeaveRepository leaveRepository,TimeRepository timeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.adminRepository=adminRepository;
		this.leaveRepository=leaveRepository;
		this.timeRepository=timeRepository;
	}


	@Override
	public void saveEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);

	}


	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		List<Employee> e=employeeRepository.findAll();
		return e;
	}


	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> theEmployee=employeeRepository.findById(theId);
		Employee emp;
		try
		{
			emp=theEmployee.get();
		}
		catch(Exception e)
		{
			return emp=null;
		}
		return emp;
	}
	
	@Override
	public Admin getAdmin(Integer id) {
		// TODO Auto-generated method stub
		Optional<Admin> a=adminRepository.findById(id);
		Admin theAdmin=null;
		try
		{
			theAdmin=a.get();
		}catch(Exception e)
		{
			return theAdmin;
		}
		return theAdmin;
	}


	@Override
	public void createLeave(Leaves theleave) {
		// TODO Auto-generated method stub
		leaveRepository.save(theleave);
	}


	@Override
	public List<TimeReport> getCustomDatesReport(String str) {
		// TODO Auto-generated method stub
		List<TimeReport> t=null;
		try
		{
			t=timeRepository.getCustomDatesReport(str);
		}
		catch(Exception e)
		{
			return t;
		}
		return t;
		
	}
	

}
