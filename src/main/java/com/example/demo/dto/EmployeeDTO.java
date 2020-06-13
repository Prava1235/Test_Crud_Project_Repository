package com.example.demo.dto;

public class EmployeeDTO {
	private String yearOfExp;
	private String empName;
	private long count;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	public String getYearOfExp() {
		return yearOfExp;
	}
	public void setYearOfExp(String yearOfExp) {
		this.yearOfExp = yearOfExp;
	}
	public long  getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public EmployeeDTO() {
	}
	public EmployeeDTO(String empName,String yearOfExp,long count) {
		super();
		this.yearOfExp = yearOfExp;
		this.empName = empName;
		this.count = count;
	}
}
	


/*package com.example.demo.dto;

public class EmployeeDTO {
	private String yearOfExp;
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private long count;
	
	public String getYearOfExp() {
		return yearOfExp;
	}
	public void setYearOfExp(String yearOfExp) {
		this.yearOfExp = yearOfExp;
	}
	public long  getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public EmployeeDTO() {
	}
	public EmployeeDTO(String empName,String yearOfExp,long count) {
		super();
		this.yearOfExp = yearOfExp;
		this.empName = empName;
		this.count = count;
	}
	public class EmployeeDTO {
	private String count;
	public EmployeeDTO(String count, String level) {
		super();
		this.count = count;
		this.level = level;
	}
	public EmployeeDTO() {
		
	}
	private String level;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
	
	}*/
/*public EmployeeDTO(String yearOfExp, String empName, long count) {
		super();
		this.yearOfExp = yearOfExp;
		this.empName = empName;
		this.count = count;
	}*/

