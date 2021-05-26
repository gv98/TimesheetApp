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
import com.app.entity.Employee;
import com.app.service.ServiceImpl;

@RestController
@RequestMapping("/timesheet")
@CrossOrigin("http://localhost:4200")
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
		Admin a=bankService.getAdmin(id);
		try
		{
		if(a.getPass().equals(pass))
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

}
