package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.dao.EmpCredRepository;
import com.app.dao.EmployeeRepository;
import com.app.dao.LeaveRepository;
import com.app.dao.TimeRepository;
import com.app.entity.Admin;
import com.app.entity.EmpCred;
import com.app.entity.Employee;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;

@Service
public class ServiceImpl implements IService {

	private EmployeeRepository employeeRepository;
	private AdminRepository adminRepository;
	private LeaveRepository leaveRepository;
	private TimeRepository timeRepository;
	private EmpCredRepository empCredRepository;
	
	@Autowired
	public ServiceImpl(EmployeeRepository employeeRepository,AdminRepository adminRepository,
			LeaveRepository leaveRepository,TimeRepository timeRepository,EmpCredRepository empCredRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.adminRepository=adminRepository;
		this.leaveRepository=leaveRepository;
		this.timeRepository=timeRepository;
		this.empCredRepository=empCredRepository;
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


	@Override
	public void saveEmpCred(EmpCred theEmpCred) {
		// TODO Auto-generated method stub
		empCredRepository.save(theEmpCred);
		
	}


	@Override
	public EmpCred findCredById(String theId) {
		// TODO Auto-generated method stub
		Optional<EmpCred> e=empCredRepository.findCredByEmail(theId);
		EmpCred emp;
		try
		{
			emp=e.get();
		}
		catch(Exception ei)
		{
			return emp=null;
		}
		return emp;
	}


	@Override
	public Employee findEmpByEmail(String theId) {
		// TODO Auto-generated method stub
		Optional<Employee> e=employeeRepository.getEmpByEmail(theId);
		Employee eo;
		try
		{
			eo=e.get();
		}
		catch(Exception ei)
		{
			return eo=null;
		}
		return eo;
	}
	

}
