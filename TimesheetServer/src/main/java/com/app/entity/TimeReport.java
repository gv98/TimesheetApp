package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@SecondaryTable(name="logbook",pkJoinColumns = @PrimaryKeyJoinColumn(name="empidl"))
public class TimeReport {
	@Id
	@Column(name="empid")
	private int empid;
	@Column(name="name")
	private String name;
	@Column(name="dat",table="logbook")
	private String dat;
	@Column(name="attendance",table="logbook")
	private String attendance;
	public TimeReport() {
		super();
	}
	public TimeReport(int empid, String name, String dat, String attendance) {
		super();
		this.empid = empid;
		this.name = name;
		this.dat = dat;
		this.attendance = attendance;
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
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
}
