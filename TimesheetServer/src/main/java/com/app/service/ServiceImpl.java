package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.dao.EmpCredRepository;
import com.app.dao.EmployeeRepository;
import com.app.dao.LeaveApplicationRepo;
import com.app.dao.LeaveRepository;
import com.app.dao.LogbookRepository;
import com.app.dao.TimeRepository;
import com.app.entity.Admin;
import com.app.entity.ELogbook;
import com.app.entity.EmpCred;
import com.app.entity.Employee;
import com.app.entity.LeaveApplication;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;

@Service
public class ServiceImpl implements IService {

	private EmployeeRepository employeeRepository;
	private AdminRepository adminRepository;
	private LeaveRepository leaveRepository;
	private TimeRepository timeRepository;
	private EmpCredRepository empCredRepository;
	private LogbookRepository logbookRepository;
	private LeaveApplicationRepo leaveApplicationRepo;
	
	@Autowired
	public ServiceImpl(EmployeeRepository employeeRepository,AdminRepository adminRepository,
			LeaveRepository leaveRepository,TimeRepository timeRepository,EmpCredRepository empCredRepository,
			LogbookRepository logbookRepository,LeaveApplicationRepo leaveApplicationRepo) {
		super();
		this.employeeRepository = employeeRepository;
		this.adminRepository=adminRepository;
		this.leaveRepository=leaveRepository;
		this.timeRepository=timeRepository;
		this.empCredRepository=empCredRepository;
		this.logbookRepository=logbookRepository;
		this.leaveApplicationRepo=leaveApplicationRepo;
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


	@Override
	public List<Leaves> viewLeaveTypes() {
		// TODO Auto-generated method stub
		List<Leaves> l=leaveRepository.findAll();
		return l;
	}


	@Override
	public void deleteLeavetype(String stri) {
		// TODO Auto-generated method stub
		leaveRepository.deleteLeave(stri);
		
	}


	@Override
	public void approveTime(int id, String str) {
		// TODO Auto-generated method stub
		timeRepository.approveTime(id, str);
		
	}


	@Override
	public void addtosheet(ELogbook e) {
		// TODO Auto-generated method stub
		logbookRepository.save(e);
	}


	@Override
	public List<ELogbook> getCustomTimeReport(int id) {
		// TODO Auto-generated method stub
		List<ELogbook> t=null;
		try
		{
			t=logbookRepository.timeSheetDash(id);
		}
		catch(Exception e)
		{
			return t;
		}
		return t;
	}


	@Override
	public void submitTime(int id, String str) {
		// TODO Auto-generated method stub
		timeRepository.submitTime(id, str);
	}


	@Override
	public ELogbook getLogById(int id) {
		// TODO Auto-generated method stub
		return logbookRepository.getLogById(id);
	}


	@Override
	public LeaveApplication applyLeave(LeaveApplication l) {
		// TODO Auto-generated method stub
		leaveApplicationRepo.save(l);
		return l;
	}


	@Override
	public List<LeaveApplication> viewLeaveapps() {
		// TODO Auto-generated method stub
		List<LeaveApplication> l=leaveApplicationRepo.findAll();
		return l;
	}


	@Override
	public List<LeaveApplication> getByLid(int lid) {
		// TODO Auto-generated method stub
		List<LeaveApplication> l=leaveApplicationRepo.getByLid(lid);
		return l;
	}


	@Override
	public void approveLeave(int empid, String dat) {
		// TODO Auto-generated method stub
		leaveApplicationRepo.approveLeave(empid, dat);
	}


	@Override
	public List<TimeReport> getMonthwiseReport(String str1) {
		// TODO Auto-generated method stub
		
		List<TimeReport> t=null;
		try
		{
			t=timeRepository.getMonthwiseReport(str1);
		}
		catch(Exception e)
		{
			return t;
		}
		return t;
	}


	@Override
	public List<TimeReport> getYearwiseReport(String str1) {
		// TODO Auto-generated method stub
		List<TimeReport> t=null;
		try
		{
			t=timeRepository.getYearwiseReport(str1);
		}
		catch(Exception e)
		{
			return t;
		}
		return t;
	}
	

}
