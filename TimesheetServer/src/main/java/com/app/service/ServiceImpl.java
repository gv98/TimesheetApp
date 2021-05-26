package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeRepository;
import com.app.entity.Employee;

@Service
public class ServiceImpl implements IService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public ServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
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

}
