package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.dao.EmployeeRepository;
import com.app.entity.Admin;
import com.app.entity.Employee;

@Service
public class ServiceImpl implements IService {

	private EmployeeRepository employeeRepository;
	private AdminRepository adminRepository;
	
	@Autowired
	public ServiceImpl(EmployeeRepository employeeRepository,AdminRepository adminRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.adminRepository=adminRepository;
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
	

}
