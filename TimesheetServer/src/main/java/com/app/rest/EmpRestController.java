package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Admin;
import com.app.entity.ELogbook;
import com.app.entity.EmpCred;
import com.app.entity.Employee;
import com.app.entity.LeaveApplication;
import com.app.entity.Leaves;
import com.app.entity.TimeReport;
import com.app.service.ServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/timesheet")
public class EmpRestController {
	
	ServiceImpl serviceImpl;
	
	@Autowired
	public EmpRestController(ServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}
	
	@PostMapping("/employees/create")
	public Employee saveAccount(@RequestBody Employee theEmployee)
	{
		serviceImpl.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@PostMapping("/employees/createauth")
	public EmpCred saveAuth(@RequestBody EmpCred theEmployee)
	{
		serviceImpl.saveEmpCred(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees/edit")
	public Employee editAccount(@RequestBody Employee theEmployee)
	{
		serviceImpl.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@GetMapping("/employees")
	public List<Employee> showAll()
	{
		System.out.println("displayed");
		return serviceImpl.showAll();
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public Employee deleteEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee=serviceImpl.findById(employeeId);
		if(theEmployee==null)
		{
			System.out.println("not found");
			return theEmployee;
		}
		serviceImpl.deleteById(employeeId);
		System.out.println("Deleted");
		return theEmployee;
	}
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId)
	{
		return serviceImpl.findById(employeeId);
	}
	
	@GetMapping("/admin/login")
	public Admin adminLogin(@RequestParam Integer id,@RequestParam String pass)
	{
		Admin a=serviceImpl.getAdmin(id);
		try
		{
		if(a.getPassword().equals(pass))
		{
			return a;
		}
		else
		{
			return a=null;
		}
		}catch(Exception e)
		{
			return a=null;
		}
	}
	
	@GetMapping("/employees/login")
	public Employee empLogin(@RequestParam String email,@RequestParam String password)
	{
		EmpCred a=serviceImpl.findCredById(email);
		Employee e;
		try
		{
		if(a.getPassword().equals(password))
		{
			e=serviceImpl.findEmpByEmail(email);
			System.out.println(e.getName());
			return e;
		}
		else
		{
			return e=null;
		}
		}catch(Exception ei)
		{
			return e=null;
		}
	}
	@PostMapping("/admin/createleave")
	public Leaves createLeave(@RequestBody Leaves theLeave )
	{
		serviceImpl.createLeave(theLeave);
		return theLeave;
	}
	
	@GetMapping("/admin/viewleavetypes")
	public List<Leaves> viewLeaves()
	{
		List<Leaves> l=serviceImpl.viewLeaveTypes();
		System.out.println(l);
		return l;
	}
	
	@DeleteMapping("/admin/deleteleavetype")
	public String deleteLeave(@RequestParam String val)
	{
		try
		{
			serviceImpl.deleteLeavetype(val);
		}
		catch(Exception e)
		{
			return val;
		}
		
		return val;
	}
	
	@GetMapping("/admin/getcustomdatesreport")
	public List<TimeReport> getCustomDatesReport(@RequestParam String str)
	{
		List<TimeReport> t=serviceImpl.getCustomDatesReport(str);
		System.out.println(t);
		return t;
	}
	
	@GetMapping("/admin/approvetime")
	public List<TimeReport> approveTime(@RequestParam int empid,@RequestParam String dat)
	{
		List<TimeReport> t=serviceImpl.getCustomDatesReport(dat);
		try
		{
			serviceImpl.approveTime(empid, dat);
		}catch(Exception e)
		{
			return t;
		}
		
		return t;
	}
	
	@PostMapping("/employee/addtimesheet")
	public ELogbook addToSheet(@RequestBody ELogbook e)
	{
		serviceImpl.addtosheet(e);
		return e;
	}
	
	@PutMapping("/employee/updatetimesheet")
	public ELogbook updateSheet(@RequestBody ELogbook e)
	{
		serviceImpl.addtosheet(e);
		return e;
	}
	
	@GetMapping("/admin/getcustomtimereport")
	public List<ELogbook> getCustomTimeReport(@RequestParam int empid)
	{
		List<ELogbook> t=serviceImpl.getCustomTimeReport(empid);
		System.out.println(t);
		return t;
	}
	
	@GetMapping("/employee/getlogbyid")
	public ELogbook getLogById(@RequestParam int pid)
	{
		ELogbook t=serviceImpl.getLogById(pid);
		System.out.println(t);
		return t;
	}
	
	@GetMapping("/admin/submittime")
	public List<TimeReport> submitTime(@RequestParam int empid,@RequestParam String dat)
	{
		List<TimeReport> t=serviceImpl.getCustomDatesReport(dat);
		try
		{
			serviceImpl.submitTime(empid, dat);
		}catch(Exception e)
		{
			return t;
		}
		
		return t;
	}
	
	@PostMapping("/employee/addleave")
	public LeaveApplication addLeave(@RequestBody LeaveApplication l)
	{
		LeaveApplication leave=serviceImpl.applyLeave(l);
		return leave;
	}
	
	@GetMapping("/admin/viewleaveapps")
	public List<LeaveApplication> viewLeaveApps()
	{
		List<LeaveApplication> l=serviceImpl.viewLeaveapps();
		return l;
	}
	
	@GetMapping("/employees/viewleavereport")
	public List<LeaveApplication> getByLid(@RequestParam int empid)
	{
		List<LeaveApplication> l=serviceImpl.getByLid(empid);
		return l;
	}
	
	@GetMapping("/admin/approveleave")
	public boolean approveLeave(int empid,String dat)
	{
		try
		{
			serviceImpl.approveLeave(empid, dat);
			return true;
		}catch(Exception e)
		{
			return true;
		}
		
	}
	
	@GetMapping("/admin/getmonthwisereport")
	public List<TimeReport> getMonthwiseReport(@RequestParam String month)
	{
		List<TimeReport> t=serviceImpl.getMonthwiseReport(month);
		System.out.println(t);
		return t;
	}
	
	@GetMapping("/admin/getyearwisereport")
	public List<TimeReport> getYearwiseReport(@RequestParam String month)
	{
		List<TimeReport> t=serviceImpl.getYearwiseReport(month);
		System.out.println(t);
		return t;
	}


}
