package com.example.demo.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Employee")
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empid")
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="yearofexp")
	private String yearOfExp;
	public int getEmpid() {
		return empId;
	}
	public void setEmpId(int empid) {
		this.empId = empid;
	}
	public String getEmpname() {
		return empName;
	}
	public void setEmpname(String empname) {
		this.empName = empname;
	}
	public String getYearOfExp() {
		return yearOfExp;
	}
	public void setYearOfExp(String yearOfExp) {
		this.yearOfExp = yearOfExp;
	}
	public Employee(int empid, String empname, String yearOfExp) {
		super();
		this.empId = empid;
		this.empName = empname;
		this.yearOfExp = yearOfExp;
	}
	
	public Employee() {
		
	}
}