package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveappl")
public class LeaveApplication {

	@Id
	@Column(name="lid")
	private int lid;
	@Column(name="empid")
	private int empid;
	@Column(name="empname")
	private String empname;
	@Column(name="dat")
	private String dat;
	@Column(name="ltype")
	private String ltype;
	@Column(name="status")
	private String status;
	public LeaveApplication() {
		super();
	}
	public LeaveApplication(int lid, int empid, String empname, String dat, String ltype, String status) {
		super();
		this.lid = lid;
		this.empid = empid;
		this.empname = empname;
		this.dat = dat;
		this.ltype = ltype;
		this.status = status;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public String getLtype() {
		return ltype;
	}
	public void setLtype(String ltype) {
		this.ltype = ltype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
