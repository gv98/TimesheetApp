package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="empid")
	private int empid;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="designation")
	private String designation;
	@Column(name="email")
	private String email;
	@Column(name="salary")
	private double salary;
	@Column(name="dob")
	private String dob;
	@Column(name="mobile")
	private double mobile;
	public Employee() {
		super();
	}
	public Employee(int empid, String name, String address, String designation, String email, double salary, String dob,
			double mobile) {
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.designation = designation;
		this.email = email;
		this.salary = salary;
		this.dob = dob;
		this.mobile = mobile;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getMobile() {
		return mobile;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	
	
	
	
	
}
