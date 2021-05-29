package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logbook")
public class ELogbook {

	@Id
	@Column(name="pid")
	private int pid;
	@Column(name="empidl")
	private int empidl;
	@Column(name="dat")
	private String dat;
	@Column(name="attendance")
	private String attendance;
	@Column(name="status")
	private String status;
	public ELogbook() {
		super();
	}
	public ELogbook(int empidl, String dat, String attendance,String status) {
		super();
		this.empidl = empidl;
		this.dat = dat;
		this.attendance = attendance;
		this.status=status;
	}
	public int getEmpidl() {
		return empidl;
	}
	public void setEmpidl(int empidl) {
		this.empidl = empidl;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}
